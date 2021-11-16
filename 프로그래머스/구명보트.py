def solution(people:list, limit:int)->int:
  answer, left, right = 0, 0, len(people)-1

  people.sort()
  
  while left<=right:
    if people[left]+people[right]<=limit:
      right-=1
      left+=1
    else:
      right-=1
    answer+=1

  return answer
