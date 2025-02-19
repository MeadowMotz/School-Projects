#include "types.h"
#include "user.h"
int isalpha(char c) {
    return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
}

char toupper(char c) {
    if (c >= 'a' && c <= 'z') {
        return c - ('a' - 'A');
    }
    return c;
}

int isspace(char c) {
    return (c == ' ' || c == '\t' || c == '\n');
}
int main() {
    char buf[1];  
    int a = read(0, buf, 1);
    while (a>0) {
        if (isalpha(buf[0])) {
            char upper = toupper(buf[0]);
            write(1, &upper, 1); 
        } else if (isspace(buf[0])) {
            char newline = '\n';
            write(1, &newline, 1); 
        }
        a = read(0, buf, 1);
    }
}