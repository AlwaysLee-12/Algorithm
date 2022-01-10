from typing import List

# conver decimal number to binary number(fill zero to satisfy the digit)
def convert_to_binary_num(n: int, decimal_num: int)-> str:
	binary_num = ''

	while decimal_num != 0:
		binary_num += str(decimal_num%2)
		decimal_num //= 2

	binary_num = binary_num[::-1]
	binary_num = binary_num.zfill(n)

	return binary_num

def solution(n: int, arr1: List[int], arr2: List[int])->List[str]:
	answer = []
	
  # conver two decimal num to bunary num and add them  
	for num1, num2 in zip(arr1, arr2):
		binary_num1 = convert_to_binary_num(n, num1)
		binary_num2 = convert_to_binary_num(n, num2)
		
		secret_map_row = ''
		for binary_digit_num1, binary_digit_num2 in zip(binary_num1, binary_num2):
			if binary_digit_num1 == '1' or binary_digit_num2 == '1':
				secret_map_row += '#'
			else:
				secret_map_row += ' '

		answer.append(secret_map_row)

	return answer
