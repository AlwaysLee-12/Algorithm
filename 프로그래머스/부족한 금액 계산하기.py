def solution(price: int, money: int, count: int)->int:
    answer = 0
    target = 0
    
    for i in range(count):
        target += (price * (i + 1))
    
    if target > money:
        answer = target - money
    
    return answer
