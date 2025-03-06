// init: The initial user-level program

#include "fcntl.h"
#include "stat.h"
#include "types.h"
#include "user.h"

char *argv[] = {"sh", 0};

int main(void) {
  int pid, wpid;

  mkdir("dev");

  if (open("dev/console", O_RDWR) < 0) {
    mknod("dev/console", 1, 1);
    open("dev/console", O_RDWR);
  }
  dup(0); // stdout
  dup(0); // stderr

  // Only 10 device major numbers are allowed by param.h
  int hellofd = open("dev/hello", O_RDWR);
  if(hellofd < 0){
    mknod("dev/hello", 7, 1); // 7 is major number, 1 is minor number 
    hellofd = open("dev/hello", O_RDWR);
  }
  close(hellofd);

  int nullfd = open("dev/null", O_WRONLY);
  if(nullfd < 0){
    mknod("dev/null", 6, 1); // 6 is major number, 1 is minor number 
    nullfd = open("dev/null", O_WRONLY);
  }
  close(nullfd);

  int zerofd = open("dev/zero", O_RDONLY);
  if(zerofd < 0){
    mknod("dev/zero", 8, 1); // 8 is major number, 1 is minor number 
    zerofd = open("dev/zero", O_RDONLY);
  }
  close(zerofd);

  int tickfd = open("dev/tick", O_RDONLY);
  if(tickfd < 0){
    mknod("dev/tick", 9, 1); // 9 is major number, 1 is minor number 
    tickfd = open("dev/tick", O_RDONLY);
  }
  close(tickfd);

  int queuefd = open("dev/queue", O_RDWR);
  if(queuefd < 0){
    mknod("dev/queue", 5, 1); // 5 is major number, 1 is minor number 
    queuefd = open("dev/queue", O_RDWR);
  }
  close(queuefd);

  for (;;) {
    printf(1, "init: starting sh\n");
    pid = fork();
    if (pid < 0) {
      printf(1, "init: fork failed\n");
      exit();
    }
    if (pid == 0) {
      exec("sh", argv);
      printf(1, "init: exec sh failed\n");
      exit();
    }
    while ((wpid = wait()) >= 0 && wpid != pid) {
      printf(1, "zombie!\n");
    }
  }
}
