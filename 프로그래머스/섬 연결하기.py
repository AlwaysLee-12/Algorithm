# 섬을 연결한다는게 핵심
def solution(n:int, costs:list)->int:
  answer= 0
  costs.sort(key= lambda cost: cost[2])
  connected= set([costs[0][0]])
  
  while len(connected)<n:
    for cost in costs:
      if cost[0] in connected and cost[1] in connected:
        continue
      if cost[0] in connected or cost[1] in connected:
        connected.update([cost[0],cost[1]])
        answer+=cost[2]
        break

  return answer
