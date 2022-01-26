def solution(s: str)-> int:
	answer = 0
  # initialize dp table
	dp_table = [[0] * 6 for _ in range(len(s))] 

	for i in range(1, len(s)):
		for length in range(1,6):
      # current index out of index 
			if i - length + 1 < 0:
				continue 
      
			current_num = int(s[i - length + 1 : i + 1])
			target_num = current_num - 1
      # target index out of index, 01 02 03 exception
			if i - length - len(str(target_num)) + 1 < 0 or (s[i - length + 1 : i + 1][0] == '0'):
				continue
      # if before num, target num same
			if int(s[i - length - len(str(target_num)) + 1 : i - length + 1]) == target_num:
        # if target num's length + 1 = current num's length ex) 99 100
				if len(str(target_num)) == len(str(current_num)) - 1:
					if dp_table[i - len(str(current_num))][length - 1] == 0:
						dp_table[i][length] = (length * 2 - 1) 
					else:
						dp_table[i][length] = (dp_table[i - len(str(current_num))][length - 1] + length)
        # target num's length, currnet num's length same
				else:
					if dp_table[i - len(str(current_num))][length] == 0:
						dp_table[i][length] = (length * 2)
					else:
						dp_table[i][length] = (dp_table[i - len(str(current_num))][length] + length)
				answer = max(answer, dp_table[i][length])

	# remove duplication code
	def solution(s: str)-> int:
	answer = 0
	dp_table = [[0] * 6 for _ in range(len(s))] 

	for i in range(1, len(s)):
		for length in range(1,6):
			if i - length + 1 < 0:
				continue 

			current_num = int(s[i - length + 1 : i + 1])
			target_num = current_num - 1
			if i - length - len(str(target_num)) + 1 < 0 or (s[i - length + 1 : i + 1][0] == '0'):
				continue

			if int(s[i - length - len(str(target_num)) + 1 : i - length + 1]) == target_num:
				if dp_table[i - len(str(current_num))][length - (len(str(current_num)) - len(str(target_num)))] == 0:
					dp_table[i][length] = (length * 2 - (len(str(current_num)) - len(str(target_num)))) 
				else:
					dp_table[i][length] = (dp_table[i - len(str(current_num))][length - (len(str(current_num)) - len(str(target_num)))] + length)
				answer = max(answer, dp_table[i][length])

	return answer
