def solution(genres, plays):
	genres_total= dict()
	answer = []

	for i in range(len(plays)):
		if genres[i] in genres_total:
			genres_total[genres[i]].append((plays[i],i))
		else:
			genres_total[genres[i]]= [(plays[i],i)]

	for i in genres_total:
		genres_total[i].sort(reverse=True)
		total=0
		for j in range(len(genres_total[i])):
			total+=genres_total[i][j][0]
		genres_total[i].insert(0,total)

	dic= sorted(genres_total.values(),reverse=True)

	for i in dic:
		if len(i)>2:
			if i[1][0]==i[2][0] and i[1][1]>i[2][1]:
				temp= i[1]
				i[1]= i[2]
				i[2]= temp
			answer.append(i[1][1])
			answer.append(i[2][1])
		else:
			answer.append(i[1][1])

	return answer
