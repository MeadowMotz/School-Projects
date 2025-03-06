#include "types.h"
#include "defs.h"
#include "param.h" // for NDEV
#include "traps.h"
#include "spinlock.h"
#include "sleeplock.h"
#include "fs.h"
#include "file.h" // for struct devsw

// count number of null characters in buffer
// @return number of nulls
int
zeroread(struct inode *ip, char *dst, int n)
{
    int count = 0;
    for (int i = 0; i<n; i++) {
        if (dst[i]=='\0') count++;
    }
    return count;
}

// O_RDONLY
int
zerowrite(struct inode *ip, char *buf, int n)
{
    return 0;
}

void
zeroinit(void)
{
  devsw[ZERO].write = zerowrite;
  devsw[ZERO].read = zeroread;
}
