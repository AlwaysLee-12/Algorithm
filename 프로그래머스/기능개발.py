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
