from typing import List

# execute dfs
def dfs(graph: List[List[int]], start: int, visited: List[int])->List[int]:
    visited.append(start)
    
    for node in graph[start]:
        if node not in visited:
            dfs(graph, node, visited)
    # return dfs result(visited node list)
    return visited[1:]
            
def solution(n: int, results: List[List[int]]) -> int:
    answer = 0
    graph = [[] for _ in range(n + 1)] 
    result = [0 for _ in range(n + 1)]
    
    # make adjacent list
    for r in results:
        graph[r[0]].append(r[1])
    
    for i in range(1, len(graph)):
        dfs_result = dfs(graph, i, [])
        # counting current node play count 
        result[i] += len(dfs_result)
        # update play count of lose node
        for node in dfs_result:
            result[node] += 1
    # if play count is n - 1, it can be placed in ranking    
    for i in range(1, len(result)):
        if result[i] == n - 1:
            answer += 1
        
    return answer
