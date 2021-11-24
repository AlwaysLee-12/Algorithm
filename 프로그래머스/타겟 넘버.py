# 재귀
from typing import List

def solution(numbers: List[int], target: int)->int:
    answer = 0
    
    def dfs(number:int, adding_index:int):
        # 외부함수의 answer를 못찾아서 nonlocal로 선언(가장 가까이 있는 함수 영역에서 answer 찾음)
        nonlocal answer
        
        if adding_index==len(numbers):
            if number==target:
                answer+=1
            return
        
        number_case= [numbers[adding_index], -numbers[adding_index]]
        
        for i in range(2):
            dfs(number+number_case[i],adding_index+1)
        
    dfs(0,0)
    
    return answer
  
# 스택
from typing import List

def solution(numbers:List[int], target:int)->int:
  answer = 0
  dfs_stack= []
  
  dfs_stack.append((0,0))
  while dfs_stack:
    adding_index,result_number= dfs_stack[-1][0], dfs_stack.pop()[1]
    
    if adding_index<len(numbers):
      dfs_stack.append((adding_index+1, result_number+numbers[adding_index]))
      dfs_stack.append((adding_index+1, result_number-numbers[adding_index]))
    else:
      if result_number==target:
        answer+=1
  
  return answer
