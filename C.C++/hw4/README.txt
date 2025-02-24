Compile in Linux with "g++ -g -std=c++11 philo.cpp -o philo -lpthread"

This solution implements a counting semaphore. Each seat is a mutex, and there are a max of 4. When a philosopher wants to eat, they must first sit down (acquire a seat), and when they're done eating, they must get up (release the seat). 

It works because it limits the number of philosophers at the table while not affecting the number of forks. Because one philosopher is guaranteed to not have their left and right forks, at least one of the other philosophers is guaranteed to have both the left and right fork, meaning they can eat. This solution ensures no philosopher starves.



philo.cpp is the original problem with deadlocks
myPhilo.cpp is my solution to the problem
