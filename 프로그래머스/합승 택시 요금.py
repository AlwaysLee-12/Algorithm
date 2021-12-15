from typing import List
import heapq
# make graph by referencing input
def make_graph(node_count: int, fares: List[List[int]])->dict:
	graph= {}

	for n in range(1,node_count+1):
		graph[n]= []

	for fare in fares:
		graph[fare[0]].append([fare[1],fare[2]])
		graph[fare[1]].append([fare[0],fare[2]])

	return graph
# make shortest path cost table from start to particular node by dijkstra
def dijkstra(node_count: int, start: int, graph: dict)->dict:
	priority_queue= []
	distance= {}
  # initialize shortest path cost table
	for n in range(1,node_count+1):
		distance[n]= float("inf")
	distance[start]= 0
  # dijkstra algorithm
	heapq.heappush(priority_queue, [start,distance[start]])
	while priority_queue:
		current_node, current_node_distance= heapq.heappop(priority_queue)
    # pass visited node
		if current_node_distance < distance[current_node]:
			continue
    # push satisfied next node to priority queue
		for next_node, next_node_distance in graph[current_node]:
			total_distance= current_node_distance+next_node_distance

			if total_distance < distance[next_node]:
				distance[next_node]= total_distance
				heapq.heappush(priority_queue, [next_node, total_distance])

	return distance

def solution(n:int, s:int, a:int, b:int, fares:List[List[int]])->int:
	answer = 0
	graph= make_graph(n, fares)
	# get dijkstra result start from s
	dijkstra_result= dijkstra(n,s,graph)
  # get answer when a,b each ride taxi
	answer= dijkstra_result[a]+dijkstra_result[b]
  # find if any shortter method exist than answer 
	for node in range(1,n+1):
    # skip s
		if node==s:
			continue
    # get dijkstra result start from particular node
		candidate_answer= dijkstra_result[node]
		particular_node_dijkstra_result= dijkstra(n,node,graph)
    # add path cost s->particular node + particular node->a + particular node->b
		candidate_answer+= particular_node_dijkstra_result[a]+particular_node_dijkstra_result[b]
    # if new answer above is smaller than existing answer, answer= new answer
		if candidate_answer < answer:
			answer= candidate_answer

	return answer
