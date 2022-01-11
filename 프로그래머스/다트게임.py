def solution(dartResult: str)->int:
	answer = 0
	score_list = []
	
	for i, dart_info in enumerate(dartResult):
    # calculate each score according to S, D, T case
		if dart_info == "S":
			continue
		elif dart_info == "D":
			score_list[-1] **= 2
		elif dart_info == "T":
			score_list[-1] **= 3
    # calculate each score according to *, # case
		elif dart_info == "*":
			score_list[-1] *= 2
			if len(score_list) > 1:
				score_list[-2] *= 2
		elif dart_info == "#":
			score_list[-1] = -score_list[-1]
    # if the case is number, just append it to list
    # but, when continuously number case, just assign 10 to list(there is only one case about continously number(10))
		else:
			if dart_info == "0" and dartResult[i-1] == "1":
				score_list[-1] = 10
			else:
				score_list.append(int(dart_info))

	answer = sum(score_list)
	
	return answer

# better one
def solution(dartResult: str)->int:
	answer = 0
	score_list = []
	
  bonus_list = ["S", "D", "T"]
	for i, dart_info in enumerate(dartResult):
    # calculate each score according to S, D, T case
		if dart_info in bonus_list:
      score_list[-1] **= bonus_list.index(dart_info)+1
    # calculate each score according to *, # case
		elif dart_info == "*":
			score_list[-1] *= 2
			if len(score_list) > 1:
				score_list[-2] *= 2
		elif dart_info == "#":
			score_list[-1] = -score_list[-1]
    # if the case is number, just append it to list
    # but, when continuously number case, just assign 10 to list(there is only one case about continously number(10))
		else:
			if dart_info == "0" and dartResult[i-1] == "1":
				score_list[-1] = 10
			else:
				score_list.append(int(dart_info))

	answer = sum(score_list)
	
	return answer
