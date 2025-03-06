#include "types.h"
#include "stat.h"
#include "user.h"
#include "fcntl.h"

int
main(int argc, char *argv[])
{
    // open device fd
    int devTickFd = open("dev/tick", O_RDONLY);
    if(0 > devTickFd) {
        printf(2, "Error: Unable to open dticks\n");
    }
    else {
        // input buffer
        char buffer[512] = {};
        // read tick counter from dev/ticks into buffer
        int n = read(devTickFd, buffer, 512);
        printf(1, "Got %d chars. Tick counter is at <%s> \n", n, buffer);
        close(devTickFd);
        devTickFd = -1;
    }
    exit();
}