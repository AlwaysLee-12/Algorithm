from typing import List

def solution(numbers: List[int], hand: str)-> str:
	answer = ''
  # initialize key pad and left, right hand position
	key_pad = [[1,2,3], [4,5,6], [7,8,9], ['*',0,'#']]
	l_position = [3, 0]
	r_position = [3, 2]

	for number in numbers:
    # if number in 1,4,7, press it with left hand and change left hand position
		if number in (1,4,7):
			l_position = [number//3, 0]
			answer += 'L'
     # if number in 3,6,9, press it with right hand and change right hand position
		elif number in (3,6,9):
			r_position = [number//4, 2]
			answer += 'R'
    # if number in 2,5,8,0, press it with the nearest hand(if distance is same, press with own's handded) and change to pressing hand position
		else:
				if number == 0:
					cur_position = [3,1]
				else:
					cur_position = [number//3, 1]
				l_diff = [abs(l - c) for l, c in zip(l_position, cur_position)]
				l_diff = sum(l_diff)

				r_diff = [abs(r - c) for r, c in zip(r_position, cur_position)]
				r_diff = sum(r_diff)

				if l_diff > r_diff:
					r_position = cur_position
					answer += 'R'
				elif l_diff < r_diff:
					l_position = cur_position
					answer += 'L'
				else:
					hand_info = hand[0]
					if hand_info == 'l':
						l_position = cur_position
					else:
						r_position = cur_position
					answer += hand_info.upper()

	return answer
