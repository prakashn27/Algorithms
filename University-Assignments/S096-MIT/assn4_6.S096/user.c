#include <stdio.h>
#include "bintree.h"

int main() {
	/*
	Insert your test code here. Try inserting nodes then searching for them.

	When we grade, we will overwrite your main function with our own sequence of
	insertions and deletions to test your implementation. If you change the
	argument or return types of the binary tree functions, our grading code
	won't work!
	*/
	insert_node(15,15);
	insert_node(16,16);
	insert_node(12,12);
	insert_node(17,17);
	insert_node(18,18);
	printf("the data in node 15 is %d\n", find_node_data(15));
	node* displaynode = NULL;
	preorder(displaynode, 0);

	return 0;
}
