#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char *argv[]) {
    int pipefd[2];
    pipe(pipefd);
    int pid = fork();
    if (pid == 0) {
        close(pipefd[1]);
        dup2(pipefd[0], STDIN_FILENO);
        close(pipefd[0]);
        execlp("wc", "wc", NULL);
        exit(1);
    } else {
        close(pipefd[0]);
        int fd = open(argv[1], O_RDONLY);
        char buffer[1024];
        ssize_t bytesRead;
        while ((bytesRead = read(fd, buffer, sizeof(buffer))) > 0) {
            write(pipefd[1], buffer, bytesRead);
        }
        close(fd);
        close(pipefd[1]);
    }
    return 0;
}