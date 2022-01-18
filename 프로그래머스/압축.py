from typing import List

def solution(msg: str)->List[int]:
	answer = []
	dic = []

  # make alphabet dictionary
	for i in range(1, 27):
		dic.append(chr(i + 64))
	
	search_i = 0
	while search_i < len(msg):
		s = msg[search_i]
		for i in range(search_i + 1, len(msg)):
      # if s + msg[i] is in dict, just concatnate them
			if (s + msg[i]) in dic:
				s += msg[i]
				search_i += 1
			else:
				break
    # if search_i is not last index of msg
		if search_i + 1 < len(msg):
			dic.append(s+msg[search_i+1])
		answer.append(dic.index(s)+1)
		search_i += 1

	return answer
