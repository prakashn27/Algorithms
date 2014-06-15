# This function gives you the kth fibonacci term
#make use of tuples
def kth_fib(k):
	a, b = 0, 1
	while k != 0:
		a, b = b, a+b
		k -= 1
	return a
