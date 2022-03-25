def solution(a: int, b: int)->str:
    answer = ''
    day_of_week = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"]
    month_last_day = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    month = 0
    for i in range(a - 1):
        month += month_last_day[i]
    
    month += b
    
    answer = day_of_week[month % 7 - 1]
    
    return answer
