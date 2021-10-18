def solution(participant, completion):
    for i in completion:
        participant.pop(participant.index(i))
    answer=participant[0]
    return answer