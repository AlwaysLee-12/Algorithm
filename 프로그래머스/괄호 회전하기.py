from collections import deque
from typing import List

# 올바른 문자열인지 판별
def is_right_str(s: List[str])->bool:
    stack = []
    # s 복사(값만. 깊은 복사)
    temp_s = s.copy()
    
    stack.append(temp_s.popleft())
    # temp_s를 stack에 넣으면서, (), [], {}가 짝지어지면 두개 다 pop
    while(len(temp_s) > 0):
        stack.append(temp_s.popleft())

        if len(stack) >= 2:
            if (stack[-2] == '[' and stack[-1] == ']') or (stack[-2] == '(' and stack[-1] == ')') or (stack[-2] == '{' and stack[-1] == '}'):
                stack.pop()
                stack.pop()
    # stack에 문자들이 남아있다면, 올바르지 않은 문자열이므로 return False
    if len(stack) > 0:
        return False
    
    return True

def solution(s: str)->int:
    answer = 0
    s = deque(s)
    
    for _ in range(len(s)):
        if is_right_str(s):
            answer += 1
        # 문자열 회전
        s.append(s.popleft())
    
    return answer
