def solution(s: str)-> int:
	answer = 0
  # make number mapping list
	num_dict = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4', 'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}
  # change number written by str to int number
	for num in num_dict.keys():
		s = s.replace(num, num_dict[num])

	answer = int(s)

	return answer
