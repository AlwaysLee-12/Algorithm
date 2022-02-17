from typing import List
from collections import deque

def solution(n: int, edge: List[int])-> int:
	answer = [[0, 0]]
	graph = [[] for _ in range(n + 1)]
	is_visited = [False for _ in range(n + 1)]
	queue = deque()

  # make adjacent list
	for dest, arrival in edge:
		graph[dest].append(arrival)
		graph[arrival].append(dest)

  # bfs
	queue.append([1,0])
	while len(queue) > 0:
		current_node = queue[0][0]
		current_distance = queue.popleft()[1]

		is_visited[current_node] = True

    # get nodes has longgest distance
		if current_distance >= answer[0][1]:
			if current_distance > answer[0][1]:
				answer.clear()
			answer.append([current_node, current_distance])

		for next in graph[current_node]:
			if not is_visited[next]:
				queue.append([next, current_distance + 1])
				is_visited[next] = True

	return len(answer)
