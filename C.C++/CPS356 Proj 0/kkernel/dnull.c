#include "types.h"
#include "defs.h"
#include "param.h" // for NDEV
#include "traps.h"
#include "spinlock.h"
#include "sleeplock.h"
#include "fs.h"
#include "file.h" // for struct devsw

// O_WRONLY
int
nullread(struct inode *ip, char *dst, int n)
{
    return 0;
}

// overwrite buffer with null characters (swallow)
// @return number of characters swallowed
int
nullwrite(struct inode *ip, char *buf, int n)
{
    for (int i = 0; i<n; i++) buf[i]='\0';
    return n;
}

void
nullinit(void)
{
  devsw[NUL].write = nullwrite;
  devsw[NUL].read = nullread;
}
