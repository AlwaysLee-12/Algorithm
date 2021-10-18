# zip()은 배열 간 같은 인덱스끼리 묶어준다. 배열의 길이가 다르면 한쪽이 남게된다.
def solution(participant, completion):
    participant.sort()
    completion.sort()

    for a,b in zip(participant,completion):
        if a!=b:
            return a
    return participant.pop()
