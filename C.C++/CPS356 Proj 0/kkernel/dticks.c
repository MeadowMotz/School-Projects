#include "types.h"
#include "param.h" // for NDEV
#include "traps.h"
#include "spinlock.h"
#include "sleeplock.h"
#include "fs.h"
#include "file.h" // for struct devsw
#include "traps.h"
#include "defs.h"

// @param number to convert to string
// @param buffer to store number string
// @return length of string + '\0'
int toString(int num, char* buf) {
    int num_digits = 0;
    int temp = num;

    // count number of digits in the integer
    while (temp > 0) {
        temp = temp / 10;
        num_digits++;
    }
    int i = num_digits - 1;
    // extract digits
    while (num > 0) {
        buf[i] = (num % 10) + '0'; // convert to ASCII character
        num = num / 10;
        i--;
    }
    buf[num_digits] = '\0';

    return num_digits+1;
}

// read tick counter and return it as a string
// @return length of string
int
tickread(struct inode *ip, char *dst, int n)
{
    return toString(ticks, dst);
}

// O_RDONLY
int
tickwrite(struct inode *ip, char *buf, int n)
{
    return 0;
}

void
ticksinit(void)
{
  devsw[TICK].write = tickwrite;
  devsw[TICK].read = tickread;
}
