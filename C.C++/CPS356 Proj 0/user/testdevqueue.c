#include "types.h"
#include "stat.h"
#include "user.h"
#include "fcntl.h"

int main(int argc, char *argv[]) {
    // open device fd
    int devQueueFd = open("dev/queue", O_RDWR);
    if (devQueueFd < 0) {
        printf(2, "Error: Unable to open queue\n");
    }
    else {
        // sample string
        char buffer[512] = "Queue write/read test.";
        // write string to dev/queue
        int n = write(devQueueFd, buffer, strlen(buffer)); 
        printf(1, "Wrote %d characters\n", n);
        // output buffer
        char buffer2[512] = {};
        // read string from dev/queue
        int m = read(devQueueFd, buffer2, sizeof(buffer2));
        printf(1, "Read %d characters: %s\n", m, buffer2);

        devQueueFd = -1;
    }
}
