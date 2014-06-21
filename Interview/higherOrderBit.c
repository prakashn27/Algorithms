/*
http://ideone.com/yWdftu

*/
#include <stdio.h>

int main(void) {
	int num = 13;
    if (!num)
    	return 0;

    int ret = 1;

    while (num >>= 1)
    	ret <<= 1;

    printf("%d",ret);
	return 0;
}
