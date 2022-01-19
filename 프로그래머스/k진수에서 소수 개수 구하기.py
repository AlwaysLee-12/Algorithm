from typing import List

# verify number is prime num or not
def is_prime(num: str)->bool:
  # if num is 1 or not digit, return false
	if num == '1' or not num.isdigit():
		return False

	num = int(num)
	flag = True
	for i in range(2, int(num**0.5)+1):
		if num % i == 0:
			flag = False

	return flag
# change input number to input notation's number
def change_to_n_notation_num(number: int, notation: int)->str:
	result = ''

	while number > 0:
		modulo_result = number % notation
		if modulo_result >= 10:
			modulo_result = chr(modulo_result + 10)
		
		result += str(modulo_result)

		number //= notation

	return result[::-1]

def solution(n: int, k: int)->int:
	answer = 0
	
	k_notation_num = change_to_n_notation_num(n,k)

	k_notation_num = k_notation_num.split('0')
 
	for knn in k_notation_num:
		if is_prime(knn):
			answer += 1

	return answer
