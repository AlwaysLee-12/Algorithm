from typing import List

def solution(d: List[int], budget: int)-> int:
	answer = 0
	
	d.sort()
  # starting smmallest one can assign most support
	for price in d:
		if budget - price >= 0:
			budget -= price
			answer += 1
	
	return answer
