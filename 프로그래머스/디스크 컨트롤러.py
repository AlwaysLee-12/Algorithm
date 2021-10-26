import heapq

def solution(jobs):
	task_len= len(jobs)
	answer = 0
	execute_list= []
	total_work_time= 0

	jobs.sort()
	heapq.heapify(jobs)

	while len(jobs)>0:
		j_len= len(jobs)
		for i in range(j_len):
			if jobs[0][0]<=total_work_time:
				temp= heapq.heappop(jobs)
				heapq.heappush(execute_list,[temp[1],temp[0]])
		
		if len(execute_list)>0:
			b= heapq.heappop(execute_list)
			total_work_time+= b[0]
			answer+= (total_work_time-b[1])
			e_len= len(execute_list)
			for i in range(e_len):
				temp=heapq.heappop(execute_list)
				heapq.heappush(jobs, [temp[1],temp[0]])
		else:
			temp= heapq.heappop(jobs)
			total_work_time=(temp[0]+temp[1])
			answer+= (total_work_time-temp[0]) 

	return answer//task_len
