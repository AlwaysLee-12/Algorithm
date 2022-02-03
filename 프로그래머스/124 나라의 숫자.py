def solution(n: int)-> str:
	answer = ''
	
	while n > 0:
		if n % 3 == 0:
			answer += '3'
			n = n // 3 - 1
		else:
			answer += str(n % 3)
			n //= 3
		
	answer = answer.replace('3','4')
	answer = answer[::-1]	
	
	return answer
