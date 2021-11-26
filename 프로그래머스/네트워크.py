def solution(n:int, computers:List[List[int]])->int:
  answer = 0
  stack= []
  visited= []

  # Visit flag initialize
  for i in range(n):
    visited.append(False)
       
  for i in range(n):
    # Search for different Network
    if visited[i]==False:
      stack.append(i)
      answer+=1
      # Connect same Network by DFS
      while stack:
        searching_node= stack.pop()
        visited[searching_node]= True
    
        for j in range(len(computers[searching_node])):
          if j!=searching_node and visited[j]==False and computers[searching_node][j]==1:
            stack.append(j)
  
  return answer
