def solve(num):
    a = []
    for i in range(num):
        b = list(str(i + 1))
        sum = 0
        for j in b:
            sum = sum + int(j)
        a.append(i + 1 + sum)
    for i in range(num):
        if (i + 1) not in a:
            print(i + 1)

solve(10000)
