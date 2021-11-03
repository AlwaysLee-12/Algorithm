# 각 요소에 *3을 해서 자리수를 맞추는게 관건(자리수 안맞추면 자리수 많은 수가 무조건 큰걸로 취급됨)
# 이후 문자의 맨 앞의 아스키값으로 비교
def solution(numbers):
	answer = ''

	numbers= list(map(str, numbers))

	numbers.sort(key=lambda element: element*3, reverse=True)

	answer= str(int(''.join(numbers)))

	return answer
