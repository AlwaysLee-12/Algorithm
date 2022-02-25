def solution(n: int)->int:
	answer = 0
	notation_result = ''
 
  # get 3 notation result(reversed)
	while n != 0:
		notation_result += str(n % 3)

		n = n // 3
  # make notation result to 10 notation
	answer = int(notation_result, 3)
	# answer = sum([(3**(len(notation_result) - 1 - i)) * int(notation_result[i]) for i in range(len(notation_result) - 1,-1,-1)])

	return answer
