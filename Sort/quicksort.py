class sort(object):
	def quicksort(self, arr):
		self.qs_helper(arr, 0, len(arr) - 1)
		return arr

	def qs_helper(self, arr, low, high):
		if low < high:
			# get the pivot element
			pivot = self.partition(arr, low, high)
			# partition into left and right sub tree
			self.qs_helper(arr, low, pivot - 1)
			self.qs_helper(arr, pivot + 1, high)

	def partition(self, arr, low, high):
		pivotIndex = (low + high) / 2
		pivotVal = arr[pivotIndex]
		self.swap(arr, pivotIndex, high)
		# container for storing the element to be swapped
		storeIndex = low
		for i in range(low, high):
			if arr[i] < pivotVal:
				self.swap(arr, i, storeIndex)
				storeIndex += 1
		self.swap(arr, storeIndex, high)
		return storeIndex

	def swap(self, arr, first, second):
		temp = arr[first]
		arr[first] = arr[second]
		arr[second] = temp

def main():
	pgm = sort()
	print pgm.quicksort([4,3,2,1, 1000, 500, 250])

if __name__ == '__main__':
	main()