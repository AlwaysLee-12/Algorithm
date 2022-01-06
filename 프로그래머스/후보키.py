from typing import List
import collections
from itertools import combinations

# use combination library
def solution(relation: List[List[str]])->int:
	answer = 0
	column_dict = collections.defaultdict(list)
	pk_list = []
	popped_column_list = []
  # make column dict made up column's data of each tuple
	for tuple in relation:
		for column in range(len(tuple)):
			column_dict[column].append(tuple[column])
	 # find single pk and append it to list
	for column in column_dict.keys():
		if len(column_dict[column])==len(set(column_dict[column])):
			pk_list.append([column])
			popped_column_list.append(column)
  # delete single pk info from column dict
	for popped_column in popped_column_list:
		column_dict.pop(popped_column)
  # find pk made up more than 2 column count 
	for combination_num in range(2,len(column_dict.keys())+1):
    # make candidate pk combination  
		combination_list = list(combinations(column_dict.keys(),combination_num))
  
		for combination in combination_list:
			continue_flag = False
      # verify minimal 
			for pk in pk_list:
				if all(item in combination for item in pk):
					continue_flag = True
					break

			if continue_flag:
				continue
      # verify uniqueness
			tuple_list = []
			for column in combination:
				tuple_list.append(column_dict[column])

			combination_tuple_list = list(zip(*tuple_list))
			if len(combination_tuple_list) == len(set(combination_tuple_list)):
				pk_list.append(list(combination))

	answer = len(pk_list)

	return answer

# dfs solution
