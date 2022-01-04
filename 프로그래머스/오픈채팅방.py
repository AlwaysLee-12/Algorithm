from typing import List

def solution(record: List[str])->List[str]:
	answer = []
	coming_and_going_info = []
	user = {}
	# save behavior and update user nick name to coming and going info list for each record
	for log in record:
		if log[0] == 'L':
			behavior, user_id = log.split(' ')

			coming_and_going_info.append(('L',user_id))
		else:
			behavior, user_id, nick_name = log.split(' ')

			if behavior == 'Enter':
				user[user_id] = nick_name

				coming_and_going_info.append(('E',user_id))
			else:
				user[user_id] = nick_name		
  # complete in and out info by referencing coming and going info list
	for info in coming_and_going_info:
		if info[0] == 'E':
			answer.append('{nick_name}님이 들어왔습니다.'.format(nick_name = user[info[1]]))
		else:
			answer.append('{nick_name}님이 나갔습니다.'.format(nick_name = user[info[1]]))
			
	return answer
