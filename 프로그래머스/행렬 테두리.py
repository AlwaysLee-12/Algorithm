from typing import List
from collections import deque

def solution(rows:int, columns:int, queries:List[int])->List[int]:
    answer = []
    queries= deque(queries)
    matrix= []  
    
    # make matrix
    for row in range(rows):
      matrix.append([row*columns+1])
      for column in range(1,columns):
        matrix[row].append(matrix[row][column-1]+1)
    
    # spin the matrix by each queries
    while queries:
      candidate_min_list=[]
      row1,col1,row2,col2= queries.popleft()
      
      for col in range(col2-1,col1-1,-1):
        matrix[row1-1][col],matrix[row1-1][col-1]= matrix[row1-1][col-1],matrix[row1-1][col]
        candidate_min_list.append(matrix[row1-1][col])
        candidate_min_list.append(matrix[row1-1][col-1])
        
      for row in range(row1-1,row2-1):
        matrix[row][col1-1],matrix[row+1][col1-1]=matrix[row+1][col1-1],matrix[row][col1-1]
        candidate_min_list.append(matrix[row][col1-1])
        candidate_min_list.append(matrix[row+1][col1-1])
        
      for col in range(col1-1,col2-1):
        matrix[row2-1][col],matrix[row2-1][col+1]=matrix[row2-1][col+1],matrix[row2-1][col]
        candidate_min_list.append(matrix[row2-1][col])
        candidate_min_list.append(matrix[row2-1][col+1])
        
      for row in range(row2-1,row1,-1):
        matrix[row][col2-1],matrix[row-1][col2-1]=matrix[row-1][col2-1],matrix[row][col2-1]
        candidate_min_list.append(matrix[row][col2-1])
        candidate_min_list.append(matrix[row-1][col2-1])
      # extract min num in spinned nums
      answer.append(min(candidate_min_list))
    
    return answer
