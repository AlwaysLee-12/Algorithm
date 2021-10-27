import heapq

def solution(operations):
	answer = [0,0]
	heap= []
	temp_heap= []

	for i in operations:
		command, num= i.split() 
		
		if command=="I":
			heapq.heappush(heap, int(num))
		else:
			if len(heap)>0:
				if int(num)==-1:
					heapq.heappop(heap)
				else:
					for i in heap:
						heapq.heappush(temp_heap, (-i,i))
					heap= temp_heap.copy()
					temp_heap.clear()
					heapq.heappop(heap)
					for i in heap:
						heapq.heappush(temp_heap, i[1])
					heap= temp_heap.copy()
					temp_heap.clear()

	if len(heap)>0:
		answer[1]= heap[0]
		for i in heap:
			heapq.heappush(temp_heap, (-i,i))
		heap= temp_heap.copy()
		answer[0]= heap[0][1]

	return answer
