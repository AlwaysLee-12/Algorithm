import itertools

def solution(numbers):
	answer = 0
	numbers= list(numbers)
	permu_list= []

	for i in range(1,len(numbers)+1):
		permu_list.extend(map(int,list(map(''.join, itertools.permutations(numbers,i)))))

	permu_list= list(set(permu_list))

	for i in permu_list:
		if i>=2:
			check= True

			for j in range(2,int(i**0.5)+1):
				if i%j==0:
					check= False
					break
			if check:
		
				answer+=1

	return answer
