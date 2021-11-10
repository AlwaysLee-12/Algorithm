#중복제거하고, pop을 이용
def solution(n, lost, reserve):
    answer = n
    
    lost.sort()
    reserve.sort()
    
    for i in lost:
        if i in reserve:
            lost[lost.index(i)]=-1
            reserve.pop(reserve.index(i))
            
    for i in lost:
        if i-1 in reserve:
            lost[lost.index(i)]=-1
            reserve.pop(reserve.index(i-1))
        elif i+1 in reserve:
            lost[lost.index(i)]=-1
            reserve.pop(reserve.index(i+1))
    
    for i in lost:
        if i >= 0:
            answer-=1
            
    return answer
  
  #다른 방식으로 중복을 제거하고, remove를 이용한 방법
  def solution(n, lost, reserve):
  answer = n
  
  lost.sort()
  reserve.sort()
  
  lost_no_overlab= [i for i in lost if i not in reserve]
  reserve_no_overlab= [i for i in reserve if i not in lost]
  
  for i in reserve_no_overlab:
    if i-1 in lost_no_overlab:
      lost_no_overlab.remove(i-1)
    elif i+1 in lost_no_overlab:
      lost_no_overlab.remove(i+1)
  
  return answer-len(lost_no_overlab)
