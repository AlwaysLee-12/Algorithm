from typing import List
import re

def calculate_jaccard_similarity(str_list1: List[str], str_list2: List[str])-> int:
	intersection_count = 0
	sum_len = len(str_list1) + len(str_list2)

	if sum_len == 0:
		return 65536

	for string in str_list1:
		if string in str_list2:
			intersection_count += 1
			str_list2.pop(str_list2.index(string))

	return int((intersection_count / (sum_len - intersection_count)) * 65536)

def pop_list(popped_index_list: List[int], str_list: List[str])-> None:
	while popped_index_list:
		str_list.pop(popped_index_list.pop())

# apply regular expression and return will be popped index list
def apply_regular_expression(str_list: List[str])-> List[int]:
	p = re.compile('[^a-z]')
	popped_index_list = []
	
	for i in range(len(str_list)):
		m = p.search(str_list[i])

		if m != None:
			popped_index_list.append(i)

	return popped_index_list

def make_multiple_set_elements(string: str)-> List[str]:
	str_list = []
	
	for i in range(len(string)-1):
		str_list.append(string[i] + string[i+1])

	return str_list

def solution(str1: str, str2: str)-> int:
	answer = 0

	str1 = str1.lower()
	str2 = str2.lower()
	
	str_list1 = make_multiple_set_elements(str1)
	str_list2 = make_multiple_set_elements(str2)

	poppend_index_list1 = apply_regular_expression(str_list1)
	poppend_index_list2 = apply_regular_expression(str_list2)

	pop_list(poppend_index_list1, str_list1)
	pop_list(poppend_index_list2, str_list2)

	answer = calculate_jaccard_similarity(str_list1, str_list2)

	return answer
