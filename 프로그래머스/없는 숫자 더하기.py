# pool one
from typing import List

# search target number by binary search
def binary_search(target: int, numbers: List[int])-> int:
	left = 0
	right = len(numbers) - 1

	while left <= right:
		mid = (left + right) // 2

		if numbers[mid] == target:
			return mid
		elif numbers[mid] < target:
			left = mid + 1
		else:
			right = mid - 1

	return None

def solution(numbers: List[int])-> int:
	answer = 0
	
	numbers.sort()

	for i in range(10):
		if binary_search(i, numbers) == None:
			answer += i
	
	return answer

# easy one
def solution(numbers: List[int])-> int:
  return 45 - sum(numbers)
