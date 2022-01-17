from typing import List

# calculate start time
def minus_t(s: int, t: str) -> int:
    t = int(float(t.replace("s", "")) * 1000)

    return s - t + 1


def change_to_milisecond(s: str):
    splitted_s = s.split(":")
    hour, minute, second = splitted_s[0], splitted_s[1], float(splitted_s[2])

    hour = int(hour) * 3600
    minute = int(minute) * 60

    return int((hour + minute + second) * 1000)


def solution(lines: List[str]) -> int:
    answer = 0
    start_list = []
    end_list = []
    # make start and end list
    for line in lines:
        splitted_line = line.split(" ")
        end_milisec = change_to_milisecond(splitted_line[1])
        start_milisec = minus_t(end_milisec, splitted_line[2])

        start_list.append(start_milisec)
        end_list.append(end_milisec)
    # count current start time count <= than end time + 999  
    for end_milisec_i in range(len(end_list)):
        end_milisec = end_list[end_milisec_i]
        maximum = 0

        for start_milisec_i in range(end_milisec_i, len(start_list)):
            if start_list[start_milisec_i] <= end_milisec + 999:
                maximum += 1
        answer = max(maximum, answer)

    return answer
