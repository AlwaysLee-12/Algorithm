def solution(left: int, right: int)-> int:
	answer = 0

	for num in range(left, right + 1):
		sqaure_result = num**0.5
    # perfect square check
    # if it is perfect square, it's divisor length is odd number
    # else it's divisor length is even number
		if int(sqaure_result)**2 != num:
			answer += num
		else:
			answer -= num

	return answer
