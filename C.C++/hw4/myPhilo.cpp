#include <array>
#include <mutex>
#include <thread>
#include <atomic>
#include <chrono>
#include <iostream>
#include <string>
#include <random>
#include <iomanip>
#include <string_view>
#include <condition_variable>

class Semaphore {
   std::mutex m;
   std::condition_variable cv;
   int count;
public:
   Semaphore(int init_count) : count(init_count) { }
   
   void wait() {
      std::unique_lock<std::mutex> lock(m);
      while(count == 0)
         cv.wait(lock);
      --count;
   }
   
   void signal() {
      std::unique_lock<std::mutex> lock(m);
      ++count;
      cv.notify_one();
   }
};

constexpr int no_of_philosophers = 5;

struct fork {
   std::mutex mutex;
};

struct table {
   std::atomic<bool> ready{ false };
   std::array<fork, no_of_philosophers> forks;
   // Limit seating to at most 4 philosophers concurrently.
   Semaphore seats{ 4 };
};

struct philosopher {
private:
   std::string const name;
   table & dinnertable;
   fork& left_fork;
   fork& right_fork;
   std::thread lifethread;
   std::mt19937 rng{ std::random_device{}() };
public:
   philosopher(std::string n, table & t, fork & l, fork & r) :
      name(n), dinnertable(t), left_fork(l), right_fork(r),
      lifethread(&philosopher::dine, this)
   {
   }
   
   ~philosopher()
   {
      lifethread.join();
   }
   
   void dine()
   {
      while (!dinnertable.ready);
      
      do
      {
         eat();
         think();
      } while (dinnertable.ready);
   }
   
   void print(std::string text)
   {
      // This mutex is used to serialize prints.
      static std::mutex lockprint;
      std::lock_guard<std::mutex> cout_lock(lockprint);
      std::cout << std::left << std::setw(10) << std::setfill(' ')
                << name << text << std::endl;
   }

   void eat()
   {
      // Acquire a seat before trying to pick up forks.
      dinnertable.seats.wait();
      print(" sat down at the table");
      
      static thread_local std::uniform_int_distribution<> dist(1, 6);
      
      left_fork.mutex.lock();
      print(" acquired left fork");
      
      std::this_thread::sleep_for(std::chrono::milliseconds(dist(rng) * 50));
      
      right_fork.mutex.lock();
      print(" acquired right fork");
      
      // Use lock guards with adopt_lock to manage fork mutexes.
      std::lock_guard<std::mutex> left_lock(left_fork.mutex, std::adopt_lock);
      std::lock_guard<std::mutex> right_lock(right_fork.mutex, std::adopt_lock);
      
      print(" started eating.");
      std::this_thread::sleep_for(std::chrono::milliseconds(dist(rng) * 50));
      print(" finished eating.\n");
      
      // Release the seat after eating.
      dinnertable.seats.signal();
        print(" got up from the table");
   }
   
   void think()
   {
      static thread_local std::uniform_int_distribution<> wait(1, 6);
      std::this_thread::sleep_for(std::chrono::milliseconds(wait(rng) * 150));
      print(" is thinking ");
   }
};

void dine()
{
   std::this_thread::sleep_for(std::chrono::seconds(1));
   std::cout << "Dinner started!" << std::endl;
   
   {
      table table;
      std::array<philosopher, no_of_philosophers> philosophers
      {
         {
            { "Aristotle", table, table.forks[0], table.forks[1] },
            { "Plato",    table, table.forks[1], table.forks[2] },
            { "Descartes",table, table.forks[2], table.forks[3] },
            { "Kant",     table, table.forks[3], table.forks[4] },
            { "Nietzsche",table, table.forks[4], table.forks[0] },
         }
      };
      
      table.ready = true;
      std::this_thread::sleep_for(std::chrono::seconds(5));
      table.ready = false;
   }
   
   std::cout << "Dinner done!" << std::endl;
}

int main()
{
   dine();
   return 0;
}
