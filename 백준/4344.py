a = int(input())

for i in range(a):
    b = list(map(int, input().split()))
    avg = sum(b, -b[0]) / b[0]
    count = 0
    for j in range(1, len(b), 1):
        if b[j] > avg:
            count = count + 1
    stdAvg = (count / b[0]) * 100
    print("{:.3f}%".format(stdAvg))
