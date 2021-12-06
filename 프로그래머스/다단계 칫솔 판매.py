from typing import List
from collections import deque


def solution(
    enroll: List[str], referral: List[str], seller: List[str], amount: List[int]
) -> List[int]:
    answer = []
    total_profit_list = {}
    adjacent_list = {}
    dfs_stack = []

    # initialize adjacent list, total profit list
    for person in enroll:
        adjacent_list[person] = []
        total_profit_list[person] = 0

    # make adjacent list only inclue parent node
    for person, recommender in zip(enroll, referral):
        if recommender == "-":
            continue
        else:
            adjacent_list[person].append(recommender)

    # calculate each profit in seller list
    for selected_seller, seller_amout in zip(seller, amount):
        seller_profit = seller_amout * 100
        # calculate each profit in seller list by reverse dfs(search from child node to parents node)
        dfs_stack.append([selected_seller, seller_profit])
        while dfs_stack:
            popped_selected_seller, popped_seller_profit = dfs_stack.pop()
            # calculate profit to pay to parents 
            pay_profit = int(popped_seller_profit * 0.1)
            # calculate own profit except pay profit
            total_profit_list[popped_selected_seller] = total_profit_list[
                popped_selected_seller
            ] + (popped_seller_profit - pay_profit)
            # if pay profit is 0, no need to pay to parents anymore
            if pay_profit == 0:
                break
            # search parents node to pay profit
            for recommending_seller in adjacent_list[popped_selected_seller]:
                dfs_stack.append([recommending_seller, pay_profit])

    for value in total_profit_list.values():
        answer.append(value)

    return answer
