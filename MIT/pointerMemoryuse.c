#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	/*
	int *ptr;
	int str[10];
	int i;
	ptr = str;
	*(str) = 11;
	*(str+1) = 12;
	printf("%d\t", str[0]);
	printf("%d\n", str[1]);
	for(i = 2; i < 5; i++) {
		*(str+i) = i;
		printf("%d\n", str[i]);
	}
	*/
	printf("double size : %lu\n", sizeof(double));

	char *str = (char*)malloc(5 * sizeof(char));
	strcpy(str,"hello");
	str = (char*)realloc(str, 2 * sizeof(char));
	strcpy( str, "Hello world");
	printf("%s\n", str);

	free(str);

}
