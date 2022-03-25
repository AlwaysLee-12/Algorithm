from typing import List

def solution(sizes: List[List[int]])->int:
    answer = 0
    min_list = []
    max_list = []
    
    for size in sizes:
        min_list.append(min(size))
        max_list.append(max(size))
    
    answer = max(min_list) * max(max_list)
    
    return answer
