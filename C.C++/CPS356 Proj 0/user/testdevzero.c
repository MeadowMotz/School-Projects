#include "types.h"
#include "stat.h"
#include "user.h"
#include "fcntl.h"

int
main(int argc, char *argv[])
{
    // open device fd
    int devZeroFd = open("dev/zero", O_RDONLY);
    if(0 > devZeroFd) {
        printf(2, "Error: Unable to open dzero\n");
    }
    else {
        // sample string
        char buffer[512] = "Zero";
        int m = read(devZeroFd, buffer, 512);
        // print out how many null characters in the buffer
        printf(1, "Read %d \\0's\n", m); 
        close(devZeroFd);
        devZeroFd = -1;
    }
    exit();
}