#include <ctype.h>
#include <stdio.h>
#include <unistd.h>
int main() {
    char buf;
    int a = read(0, &buf, 1);
    while (a>0) {
        if (isalpha(buf)) {
            char upper = toupper(buf);
            write(1, &upper, 1);
        } else if (isspace(buf)) {
            char newline = '\n';
            write(1, &newline, 1);
        }
        a = read(0, &buf, 1);
    }
}
