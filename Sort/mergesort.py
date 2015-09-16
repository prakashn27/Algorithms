class sort(object):
	def mergesort(self, arr):
		if len(arr) == 1:
			return arr
		left = self.mergesort(arr[0:len(arr)/2])
		right = self.mergesort(arr[len(arr)/2:len(arr)])
		result = self.merge(left, right)
		return result

	def merge(self, left, right):
		l = len(left)
		r = len(right)
		result = [0] * (l + r)
		l_index = 0
		r_index = 0
		index = 0
		for i in range(l + r):
			if l_index < l and r_index < r:
				if left[l_index] < right[r_index]:
					result[index] = left[l_index]
					l_index += 1
				else:
					result[index] = right[r_index]
					r_index += 1
				index += 1
			else:
				if l_index < l:
					result[index] = left[l_index]
					index += 1
					l_index += 1
				else:
					result[index] = right[r_index]
					r_index += 1
					index += 1
		return result

def main():
	pgm = sort()
	print pgm.mergesort([100, 1000, 500,5, 4, 3, 2, 1, 8, 10, 0 , -500])

if __name__ == '__main__':
	main()

		