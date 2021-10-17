a = int(input())

for i in range(a):
    b = list(input())
    count = 0
    score = 0
    for j in range(len(b)):
        if b[j] == "O":
            count = count + 1
            score = score + count
        else:
            count = 0
    print(score)
