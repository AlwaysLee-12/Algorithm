# Queue를 하나만 써도 되고(zip() 이용 + 리스트)
# math.ceil을 안써도 되는 방법이 있다(음수 나눗셈)
# 조건 분기를 더 적게 쓸 수도 있다.
import queue
import math

def solution(progresses, speeds):
    answer = []
    q1 = queue.Queue()
    q2 = queue.Queue()
    count = 1

    for i in range(len(progresses)):
        q1.put(progresses[i])
        q2.put(speeds[i])
    a = math.ceil((100 - q1.get()) / q2.get())

    for i in range(len(progresses)):
        if q1.qsize() == 0:
            answer.append(count)
            break
        day = math.ceil((100 - q1.get()) / q2.get())
        if day <= a:
            count = count + 1
        else:
            answer.append(count)
            count = 1
            a = day

    return answer
