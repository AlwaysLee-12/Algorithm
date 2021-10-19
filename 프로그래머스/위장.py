#clothes_dict[i[i]]= list(i[0])로 하면 ['a','b','c'] 이런식으로 들어감
#[i[0]]은 ['abc'] 이렇게 그대로 들어감
#타입은 똑같이 list여도 어떤식으로 해주냐에 따라 다른식으로 들어감(splt이 되냐 안되냐)
#경우의 수 문제에서 모든 경우의 수를 구할 때 곱의 법칙 합의 법칙 생각. 아무것도 없을때?도 같이 고려해야하는 경우 +1(이 문제의 경우 해당 부분은 착용안했을 경우를 포함해서 +1 하는것처럼)
def solution(clothes):
    clothes_dict= {}
    answer= 1
    
    for i in clothes:
        if(i[1] in clothes_dict):
            clothes_dict[i[1]].append(i[0])
        else:
            clothes_dict[i[1]]= [i[0]]
    
    for i in clothes_dict.keys():
        values= clothes_dict.get(i)
        answer= answer*(len(values)+1)
    
    return answer-1
