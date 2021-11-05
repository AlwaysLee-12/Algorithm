# 처음
def solution(answers):
	max=0
	answer = []
	supo_list= [
							[1,2,3,4,5]*2000,
							[2,1,2,3,2,4,2,5]*1250,
 							[3,3,1,1,2,2,4,4,5,5]*1000,
							]

	for i in zip(supo_list[0],answers):
		if i[0]==i[1]:
			max+=1
	answer.append(1)
	supo_list.pop(0)	

	for i in enumerate(supo_list,start=2):
		count=0
		for j in zip(i[1],answers):
			if j[0]==j[1]:
				count+=1
		if count>max:
			max=count
			answer.clear()
			answer.append(i[0])
		elif count==max:
			answer.append(i[0])

	return answer

# Better(아이디어: answers의 인덱스를 nth_supo 리스트의 길이로 나누면 반복된다)
def solution(answers):
	answer = []
	first_supo= [1,2,3,4,5]
	second_supo= [2,1,2,3,2,4,2,5]
	third_supo=	[3,3,1,1,2,2,4,4,5,5]						
	correct_count= [0,0,0]

	for i in enumerate(answers):
		if i[1]== first_supo[i[0]%len(first_supo)]:
			correct_count[0]+=1
		if i[1]== second_supo[i[0]%len(second_supo)]:
			correct_count[1]+=1
		if i[1]== third_supo[i[0]%len(third_supo)]:
			correct_count[2]+=1

	best_supo= max(correct_count)

	for i in enumerate(correct_count,start=1):
		if i[1]==best_supo:
			answer.append(i[0])

	return answer

