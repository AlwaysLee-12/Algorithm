# 스택 활용
def solution(number:str, k:int)->str:
  answer= []
 
  for num in number:
    if len(answer)==0:
      answer.append(num)
    elif num<=answer[-1]:
      answer.append(num)
    else:
      while k>0:
        answer.pop()
        k-=1
        if not answer or answer[-1]>=num:
          break
      answer.append(num)
  if k!=0:
    for i in range(k):
      answer.pop()

  answer= ''.join(answer)
     
  return answer
