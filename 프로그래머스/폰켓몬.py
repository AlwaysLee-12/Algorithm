from typing import List

def solution(nums: List[int])->int:
    answer = 0
    
    # maximum count to get pocketmon
    get_pocketmon_count = len(nums) // 2
    # pocketmon variability
    pocketmon_variability = len(set(nums))
    
    # if maximum count to get pocketmon bigger than pocketmon variability
    # get pocketmon variability count
    if get_pocketmon_count > pocketmon_variability:
        answer = pocketmon_variability
    # else get maximum count to get pocketmon
    else:
        answer = get_pocketmon_count
    
    return answer
