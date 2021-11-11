def solution(name: str)->int:
  answer = 0
  side_move_count= len(name)-1
  next= 0

  for index,alphabet in enumerate(name):
    # Get minimum up,down moving count
    answer+=min(ord(alphabet)-ord("A"), ord("Z")-ord(alphabet)+1)
    
    # find the end of "A"
    next= next+1
    while next<len(name) and name[next]=="A":
      next+=1
    
    # Get minimum left,right moving count
    side_move_count= min(side_move_count, index*2+(len(name)-next))
  
  answer+=side_move_count
  
  return answer
