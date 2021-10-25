def solution(prices):
	answer = []
	
	for i in range(len(prices)):
		stack= []
		stack.append(prices[i])
		for j in range(i+1,len(prices),1):
				stack.append(prices[j])
				if stack[len(stack)-1]<prices[i]:
					break
		answer.append(len(stack)-1)
		
	return answer
