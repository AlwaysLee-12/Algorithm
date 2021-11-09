# 인자로 들어온 것들은 무조건 사용하기
def solution(brown, yellow):
  answer = []
  multi_result= []
  
  for i in range(1,int(yellow**0.5)+1):
    if yellow%i==0:
      multi_result.append([i])
  
  for i in multi_result:
    i.append(yellow//i[0])
    
  for i in multi_result:
    if i[1]*2+i[0]*2+4==brown:
      answer.append(i[1]+2)
      answer.append(i[0]+2)	
    
  return answer

# 위 과정을 압축한 더 효율적인 코드(새로운 리스트 없이도 풀 수 있음)
def solution(brown, yellow):
    answer = []
    
    for i in range(1,int(yellow**0.5)+1):
        if yellow%i==0:
            if 2*(i+yellow//i)+4==brown:
                answer.append(yellow//i+2)
                answer.append(i+2)	
    
    return answer
