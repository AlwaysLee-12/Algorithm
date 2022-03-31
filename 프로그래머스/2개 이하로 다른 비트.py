from typing import List

def solution(numbers: List[int])->List[int]:
    answer = []
    
    for number in numbers:
        number = int(number)
        # number가 짝수면 그냥 +1 한게 최소
        if number % 2 == 0:
          answer.append(number + 1)
        # 홀수면, 오른쪽부터 0인 것을 찾아 1로 바꾸고 그 뒤에 있는 비트를 0으로 
        else:
          bi_num = '0' + bin(number)[2:]
          idx = bi_num.rfind('0')
          bi_num = list(bi_num)

          bi_num[idx] = '1'
          bi_num[idx + 1] = '0'

          answer.append(int(''.join(bi_num), 2))
        
    return answer
