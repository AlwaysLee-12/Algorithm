def solution(s: str)->str:
    answer = ''
    
    if len(s) % 2 == 0:
        answer = s[len(s) // 2 - 1]
        
    answer += s[len(s) // 2]
    
    return answer
