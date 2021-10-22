# enumerate() 사용. priorities= [(i,j) for i,j in enumerate(priorities)] => (인덱스정보,값)
# any() 사용 내부 조건중 맞는게 하나라도 있으면 true. if any(current[1]>p[1] for p in priorities) 
def solution(priorities, location):
	check=[False for i in range(len(priorities))]
	check[location]=True
	answer= 0
	
	while len(priorities)>0:
		temp= priorities[0]
		tempCheck= check[0]
		if temp<max(priorities):
			priorities.pop(0)
			check.pop(0)
			priorities.append(temp)
			check.append(tempCheck)
		else:
			priorities.pop(0)
			check.pop(0)
			answer+=1
			if tempCheck==True:
				break	
	return answer
