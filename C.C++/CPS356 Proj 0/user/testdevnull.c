#include "types.h"
#include "stat.h"
#include "user.h"
#include "fcntl.h"

int
main(int argc, char *argv[])
{
    // open device fd
    int devNullFd = open("dev/null", O_WRONLY);
    if(0 > devNullFd) {
        printf(2, "Error: Unable to open dnull\n");
    }
    else {
        // sample string
        char buffer[512] = "This goes nowhere.";
        // send string to dev/null
        int num = write(devNullFd, buffer, 512);
        printf(1, "Swallowed <%d> characters\n", num);
        close(devNullFd);
        devNullFd = -1;
    }
    exit();
}