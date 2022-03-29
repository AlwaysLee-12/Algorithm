from typing import List
import heapq

# K시간 안에 배달 가능한 마을 수 counting
def count_delivery_possible_villege(distance: List[int], answer: int, K: int):
  for d in distance:
    if d <= K:
      answer += 1

  return answer

# 다익스트라를 이용해 1로부터 나머지 마을까지 최단경로 계산
def dijkstra(graph: List[List[int]], distance: List[int]):
  priority_queue = []
  
  heapq.heappush(priority_queue, [1, 0])
  while priority_queue:
    current_node, current_distance = heapq.heappop(priority_queue)

    if current_distance < distance[current_node]:
      continue

    for next_node, next_distance in graph[current_node]:
      total_distance = current_distance + next_distance

      if total_distance < distance[next_node]:
        distance[next_node] = total_distance
        heapq.heappush(priority_queue, [next_node, total_distance])
  
  return distance

def solution(N: int, road: List[List[int]], K: int)->int:
    answer = 0
    graph = [[] for _ in range(N + 1)]
    distance = []
    
    # 인접 리스트 생성
    for connect_info in road:
      graph[connect_info[0]].append([connect_info[1], connect_info[2]])
      graph[connect_info[1]].append([connect_info[0], connect_info[2]])

    # 1로부터 나머지 정점들로 갈 수 있는 최단거리가 담겨있는 List
    for i in range(len(graph)):
      distance.append(float('inf'))
    distance[1] = 0
  
    distance = dijkstra(graph, distance)

    answer = count_delivery_possible_villege(distance, answer, K)
    
    return answer
