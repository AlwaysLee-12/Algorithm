import collections
from typing import List
from itertools import combinations

def solution(orders:List[str], course:List[int])->List[str]:
    answer = []
    
    # sort each order
    for i in range(len(orders)):
        orders[i]= "".join(sorted(orders[i]))
   
    # find menu combination by each combination count
    for combination_count in course:
        menu_combination_list= []
        max_candidate_combination_count= 0
        candidate_combination_list= []
        # get combination cases set
        for order in orders:
            menu_combination_list+=list(combinations(order,combination_count))

        menu_combination_list= set(menu_combination_list)
        # examine each combination case are valid
        for menu_combination in menu_combination_list:            
            candidate_combination_count= 0
            for order in orders:
                if combination_count>len(order):
                    continue
                menu_include_flag= True
                for menu in menu_combination:
                    if menu not in order:
                        menu_include_flag= False
                        break
                if menu_include_flag:
                    candidate_combination_count+=1
            # make candidate menu combination list among verified combination case  
            if candidate_combination_count>=2 and candidate_combination_count>=max_candidate_combination_count:
                
                candidate_combination_list.append(["".join(menu_combination),candidate_combination_count])
                max_candidate_combination_count= candidate_combination_count                
        # add maximum ordered menu combination case to final menu combination list         
        for candidate_combination in candidate_combination_list:
            if candidate_combination[1]== max_candidate_combination_count:
                
                answer.append(candidate_combination[0])
    
    answer.sort()
    
    return answer
