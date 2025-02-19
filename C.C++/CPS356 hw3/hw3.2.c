#include "user.h"
#include "fcntl.h"
#include "types.h"
#include "stdint.h"
int main(int argc, char *argv[]) {
    int pipefd[2];
    pipe(pipefd);
    int pid = fork();
    if (pid == 0) {
        close(pipefd[1]);
        dup(pipefd[0]);
        close(pipefd[0]);
        char *arg[] = {"wc", 0};
        exec("wc", arg);
        exit();
    } else {
        close(pipefd[0]);
        int fd = open(argv[1], O_RDONLY);
        char buffer[1024];
        int bytesRead;
        while ((bytesRead = read(fd, buffer, sizeof(buffer))) > 0) {
            write(pipefd[1], buffer, bytesRead);
        }
        close(fd);
        close(pipefd[1]);
    }
    return 0;
}
