def solution(routes):
    answer = 0

    routes.sort(key=lambda x: (x[0], x[1]))
    target = routes[0][1]
    answer += 1
    for i in range(1, len(routes)):
        if target >= routes[i][0]:
            if target >= routes[i][1]:
                target = routes[i][1]
        else:
            target = routes[i][1]
            answer += 1

    return answer
