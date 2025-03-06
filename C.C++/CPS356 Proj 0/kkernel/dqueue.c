#include "types.h"
#include "defs.h"
#include "param.h" // for NDEV
#include "traps.h"
#include "spinlock.h"
#include "sleeplock.h"
#include "fs.h"
#include "file.h" // for struct devsw

#define QUEUE_SIZE 8192 
typedef struct {
    char arr[QUEUE_SIZE];
    int front;
    int rear;
    int count; 
} CircularQueue;
CircularQueue q;

int isFull() {
    return (q.count == QUEUE_SIZE);
}

int isEmpty() {
    return (q.count == 0);
}

// add char to queue
// @param char to add to queue
void enqueue(char value) {
    // block if full
    if (isFull()) {
        cprintf("Queue is full\n");
        return;
    }
    q.rear = (q.rear + 1) % QUEUE_SIZE;
    q.arr[q.rear] = value;
    q.count++;
}

// remove char from queue
// @return removed char
char dequeue() {
    if (isEmpty()) {
        return '\0';
    }
    char value = q.arr[q.front];
    q.front = (q.front + 1) % QUEUE_SIZE;
    q.count--;
    return value;
}

// fill buffer with contents of queue
// @return bytes read
int queueread(struct inode *ip, char *dst, int n) {
    int i;
    for (i = 0; i < n; i++) {
        char c = dequeue();
        if (c == '\0') break; // stop reading if empty
        dst[i] = c;
    }
    return i; 
}

// write string in buffer to queue
// @return bytes written
int queuewrite(struct inode *ip, char *buf, int n) {
    int i;
    for (i = 0; i < n; i++) {
        if (isFull()) break; // stop writing if full
        enqueue(buf[i]);
    }
    return i; 
}

void queueinit(void) {
    devsw[QUEUE].write = queuewrite;
    devsw[QUEUE].read = queueread;
    q.front = 0;
    q.rear = -1;
    q.count = 0;
}
