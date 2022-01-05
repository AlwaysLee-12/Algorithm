from typing import List
from bisect import bisect_left, bisect_right

def solution(N: int, stages: List[int])-> List[int]:
	answer = []
	failure_rate_list = []
	
	stages.sort()
	# get failure of each stage
	for stage in range(1,N+1):
		reach_player_num = len(stages) - bisect_left(stages,stage)
		cannot_clear_player_num = stages.count(stage)
    # if there's no player to reach particular stage, failure is 0, if not, calculate failure
		if reach_player_num == 0:
			failure_rate = 0
		else:
			failure_rate = cannot_clear_player_num / reach_player_num

		failure_rate_list.append((stage,failure_rate))
  # failure rate desc, stage num asc
	failure_rate_list.sort(key = lambda a : (-a[1],a[0]))

	for stage, failure_rate in failure_rate_list:
		answer.append(stage)

	return answer
