from typing import List

def solution(numbers: List[int])->List[int]:
    answer = []
    
    for n1_i in range(len(numbers) - 1):
        for n2_i in range(n1_i + 1, len(numbers)):
            candidate_number = numbers[n1_i] + numbers[n2_i]
            
            if candidate_number not in answer:
                answer.append(candidate_number)
    
    answer.sort()
    
    return answer
