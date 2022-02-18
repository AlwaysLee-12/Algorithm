def solution(N: int, number: int)-> int:
  # if there's no matching thing within 8, returns -1
	answer = -1
  # initialize dp list
	dp = [ [] for _ in range(9) ]
  
	dp[1].append(N)

	if number == N:
		return 1
	# find if target exists within 8
	for i in range(2,9):
		case_list = set()
    # link N by i ex) i = 2, N = 2 -> 22
		case_list.add(int(str(N) * i))
    # find combination to make i ex) i = 4 -> 1,3 2,2
		for half_i in range(1, i // 2 + 1):
      # calculate each case 
			for left_reference in dp[half_i]:
				for right_reference in dp[i - half_i]:
					case_list.add(left_reference + right_reference)
					case_list.add(left_reference - right_reference)
					case_list.add(right_reference - left_reference)
					case_list.add(left_reference * right_reference)
          # for 0 division exception
					if right_reference != 0:
						case_list.add(left_reference // right_reference)
					if left_reference != 0:
						case_list.add(right_reference // left_reference)
    # if get target, returns i
		if number in case_list:
			answer = i
			break
    # if don't get target, insert case list to dp list and continue to find target
		dp[i].extend(list(case_list))

	return answer
