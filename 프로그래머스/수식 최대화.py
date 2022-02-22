import re
from itertools import permutations

def solution(expression: str)-> int:
	answer = 0
	
  # extract operand, operation
	operand = re.split('[*+-]', expression)
	operation = re.findall('[*+-]', expression)

  # get operation priority combination by permutation
	operation_set = set(operation)
	operation_priority_combination = list(permutations(operation_set, len(operation_set)))
	
  # get biggest calculate case 
	for operation_priority in operation_priority_combination:
    # copy operand, operation list 
		temp_operand_list = operand[:]
		temp_operation_list = operation[:]
    # calculate by higher priority operation
    # using insert, pop
		for o in operation_priority:
			while o in temp_operation_list:
				operation_idx = temp_operation_list.index(o)

				current_operation = temp_operation_list.pop(operation_idx)
				operand1 = int(temp_operand_list.pop(operation_idx))
				operand2 = int(temp_operand_list.pop(operation_idx))

				if current_operation == '*':
					temp_operand_list.insert(operation_idx, operand1 * operand2)
				elif current_operation == '+':
					temp_operand_list.insert(operation_idx, operand1 + operand2)
				else:
					temp_operand_list.insert(operation_idx, operand1 - operand2)

		if abs(temp_operand_list[0]) > answer:
			answer = abs(temp_operand_list[0])

	return answer
