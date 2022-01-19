from typing import List

def solution(id_list: List[str], report: List[str], k: int)-> List[int]:
	answer = []
	declaration_count = {}
	user_dict = {}
	
  # initialize dictionarys
	for id in id_list:
		declaration_count[id] = [[], 0]
		user_dict[id] = 0
  # remove duplication
	report = set(report)
  # count user's reported count and save reporter
	for r in report:
		splitted_r = r.split(' ')
		reporter, reported = splitted_r[0], splitted_r[1]

		declaration_count[reported][1] += 1
		declaration_count[reported][0].append(reporter)
  # if user's reported count is bigger or equal than k, add + 1 to reporter's notice count
	for user in declaration_count.keys():
		if declaration_count[user][1] >= k:
			for u in declaration_count[user][0]:
				user_dict[u] += 1

	answer = list(user_dict.values())

	return answer
