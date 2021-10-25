def solution(bridge_length, weight, truck_weights):
	answer = 0
	a= [0 for i in range(bridge_length)]
	while len(truck_weights)>0:
		a.pop(0)
		if truck_weights[0]+sum(a)-a[0]<=weight:
			a.append(truck_weights.pop(0))
		else:
			a.append(0)
		answer+=1
	
	return answer+bridge_length
