#include <stddef.h>
#include "bintree.h"
/*
constraint that the left node's ID is less than the parent node's ID, and the right node's ID is larger than the parent node ID. 
No two nodes will have the same identifier. A node can have less than two children; 
in that case, one or more of its child pointers can be NULL.
*/
///*** DO NOT CHANGE ANY FUNCTION DEFINITIONS ***///

// Recall node is defined in the header file
node* root = NULL;

// Insert a new node into the binary tree with node_id and data
void insert_node(int node_id, int data) {
	node* current = root;
	node* new_node = (node*)malloc(sizeof(node));
	new_node->node_id = node_id;
	new_node->data = data;
	new_node->left = NULL;
	new_node->right = NULL;
	if(current == NULL) {
		root = new_node;
	}
	else {
		do {
			if(current->node_id < node_id) { // goes to the right
				if(current->right == NULL) {
					current->right = new_node;
					return;
				}
				else current = current->right;
			}
			else {
				if(current->left == NULL) {
					current->left = new_node;
					return;
				}
				else current = current->left;
			}

		}while(current!=NULL);
	}

}
/*
void insert_node(int node_id, int data) {
	if(root == NULL) {
		root->node_id = node_id;
		root->data = data;
		root->left = NULL;
		root->right = NULL;
	}
	else{
		node current = NULL;
		if(root->node_id > node_id) { // goes to the right
			current = root->right;
			insert(current, node_id, data);
		}
		else { // goes to left (node_id are not same hece this is fine)
			current = root->left;
			insert(current, node_id, data);
		}
	}

}
void insert(node current, int node_id, int data) {
	if(current == NULL) {
		root->node_id = node_id;
		root->data = data;
		root->left = NULL;
		root->right = NULL;
	}
	if(current->node_id > node_id) { // goes to the right
			current = current->right;
			insert(current, node_id, data);
		}
		else { // goes to left (node_id are not same hece this is fine)
			current = current->left;
			insert(current, node_id, data);
		}
	}

}
*/

// Find the node with node_id, and return its data
int find_node_data(int node_id) {
	/*
	if node_id < root->node_id traverse left
	else traverse rigth
	*/
	node* current = malloc(sizeof(node));
	current = root;
	do {
		if(node_id == root->node_id) {
			return root->data;
		}
		if(node_id < root->node_id) {
			current = current->left;
		}
		else {
			current= current->right;
		}
	} while(current != NULL);
	return (int)NULL; //in case if the data is not found
}
/* preorder
prints the elements like root, left, right;
*/
void preorder(node* node, int i) {
	if(i == 0) { node = root;}
	if(node) {
		printf("%d\n", node->data);
		preorder(node->left, 1);
		preorder(node->right, 1);
	}
}

///***** OPTIONAL: Challenge yourself w/ deletion if you want ***///
/*//Find and remove a node in the binary tree with node_id. 
//Children nodes are fixed appropriately.
void remove_node(int node_id) {
	
}
*/
