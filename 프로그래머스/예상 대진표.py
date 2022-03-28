def solution(n: int, a: int, b: int)->int:
    answer = 0
    
    # a와 b가 같아질 떄까지 반복
    # a와 b의 다음 라운드에서의 번호가 같으면, 서로 경기 상대였던 것이기 때문
    while a != b:
        a = (a + 1) // 2
        b = (b + 1) // 2
        
        answer += 1

    return answer
