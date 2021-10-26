import heapq

def solution(scoville, K):
	answer = 0
	min_heap= []

	for i in scoville:
		heapq.heappush(min_heap,i)

	while len(min_heap)>1:
		first_min= heapq.heappop(min_heap)
		second_min= heapq.heappop(min_heap)
		scoville_result= first_min+(second_min*2)
		
		heapq.heappush(min_heap, scoville_result)
		answer+=1

		if(min_heap[0]>=K):
			return answer

	return -1
