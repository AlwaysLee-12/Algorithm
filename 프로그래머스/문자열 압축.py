def solution(s: str)->int:
	answer = 1001
  # if s's length is 1, just return 1
	if len(s)==1:
		return 1
  # find min string length among each slicing unit
	for i in range(1,(len(s)//2)+1):
		l= []
    # make sliced string list by each slicing unit
		for j in range(0,len(s),i):
			l.append(s[j:j+i])
    # initialize compression result list
		compression_result= [l[0]]
		count=0
    # proccess compression 
		for st in l:
			if st==compression_result[-1]:
				count+=1
			else:
				if count<=1:
					compression_result.append(st)
				else:
					compression_result.append(str(count))
					compression_result.append(st)
				count=1

		if count>1:
			compression_result.append(str(count))
		
		compression_result= ''.join(compression_result)

		if len(compression_result)<answer:
			answer=len(compression_result)

	return answer
