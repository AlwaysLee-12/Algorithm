from collections import deque
from typing import List

def solution(maps: List[List[int]])->int:
	answer = -1
	queue = deque()
	move_list = [(-1, 0), (0, 1), (1, 0), (0, -1)]
	
  # bfs
	queue.append([0, 0, 1])
	while(len(queue) != 0):
		current_x, current_y, current_distance = queue.popleft()
    # 지나간 maps 표시(재방문 방지) 따로 visited를 두지 않는 이유
		maps[current_x][current_y] = 0
		# 대각선 끝에 도달하면 종료
		if current_x == len(maps) - 1 and current_y == len(maps[0]) - 1:
			answer = current_distance
			break
		# 좌 우 상 하에 갈 수 있는 곳 탐색
		for move in move_list:
			next_x = current_x + move[0]
			next_y = current_y + move[1]
			next_distance = current_distance + 1
			# 갈 수 있는 곳이면 이동, 지나간 곳으로 표시
			if next_x >= 0 and next_x < len(maps) and next_y >= 0 and next_y < len(maps[0]) and maps[next_x][next_y] == 1:
				queue.append([next_x, next_y, next_distance])
				maps[next_x][next_y] = 0
				
	return answer
