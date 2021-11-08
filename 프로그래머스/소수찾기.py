# 해당 수가 소수인지 판별할 때, 2~n까지 나눠보는 것이 아닌, 2~루트n+1까지만 나눠보면 됨
# 10이 소수인가, 10의 약수: 1,2,5,10 (여기서 숫자 2부터 루트10+1인 4까지 10을 나눔) -> 2로 나눠짐 -> 소수(5부터는 나눌 필요가 없음. 어차피 대칭이기때문에)
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
