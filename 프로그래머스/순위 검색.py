from typing import List
from bisect import bisect_left

def solution(info: List[str], query: List[str]) -> List[int]:
    answer = []
    info_list = []
    query_list = []
    info_dict = {}

    # make info to list
    for candidate_conditions in info:
        info_list.append(candidate_conditions.split(" "))

    info_list.sort(key=lambda a: (int(a[4])))
    # make info list set
    for candidate_conditions in info_list:
        if " ".join(candidate_conditions[0:-1]) not in info_dict.keys():
            info_dict[" ".join(candidate_conditions[0:-1])] = [
                int(candidate_conditions[4])
            ]
        else:
            info_dict[" ".join(candidate_conditions[0:-1])].append(
                int(candidate_conditions[4])
            )
    # make query to list
    for inquiry_conditions in query:
        splited_inquiry_condition = inquiry_conditions.split(" ")
        query_list.append(
            list(value for value in splited_inquiry_condition if value != "and")
        )
    # count satisfied candidate by each inquiry 
    for inquiry_conditions in query_list:
        inquiry_score = int(inquiry_conditions.pop())
        satisfied_candidate_count = 0
        considering_conditions_index_list = []
        # find considering condition in inquiry conditions
        for i, inquiry_condition in enumerate(inquiry_conditions):
            if inquiry_condition != "-":
                considering_conditions_index_list.append(i)
        # find candidate count matched with particular inquiry
        for candidate_conditions in info_dict.keys():
            candidate_conditions_list = candidate_conditions.split(" ")
            satisfied_flag = True
            # verify if this candidates match with current inquiry conditions
            for condition_index in considering_conditions_index_list:
                if (
                    candidate_conditions_list[condition_index]
                    != inquiry_conditions[condition_index]
                ):
                    satisfied_flag = False
                    break
            # if this candidate matched with current inquiry, count this candidates
            if satisfied_flag:
                # filter out candidates if candidate's score is not satisfied among candidates filtered out by conditions by binary search
                binary_search_result = bisect_left(
                    info_dict[candidate_conditions], inquiry_score
                )
                satisfied_candidate_count += (
                    len(info_dict[candidate_conditions]) - binary_search_result
                )

        answer.append(satisfied_candidate_count)

    return answer
