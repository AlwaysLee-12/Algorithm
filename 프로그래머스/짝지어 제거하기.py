def solution(s: str)-> int:
    answer = []
    s = list(s)
    
    answer.append(s.pop())
    # until s is empty
    while len(s) > 0:
        # if stack is not empty and sequalized two string is same
        # remove them
        if len(answer) > 0 and s[-1] == answer[-1]:
            answer.pop()
            s.pop()
        # else append string to stack
        else:
            answer.append(s.pop())
        
    return 0 if len(answer) > 0 else 1
