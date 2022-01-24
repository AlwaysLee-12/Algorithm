from typing import Dict, List
from collections import defaultdict, deque

def solution(board: List[List[int]], moves: List[int])-> int:
	answer = 0
	changed_board = defaultdict(deque)
	stack = []

  # change board to comfortable board to solve the problem
	for row in range(len(board)):
		for col in range(len(board[0])):
      # except 0(not a doll, just blank)
			if board[row][col] != 0:
				changed_board[col].appendleft(board[row][col])
  # fill the basket from board
	for move_i in range(len(moves)):
    # if basket is empty, continue
		if len(changed_board[moves[move_i] - 1]) == 0:
			continue

		stack.append(changed_board[moves[move_i] - 1].pop())
		# if there are same things in basket, pop them and count popped things 
		if len(stack) > 1 and stack[-1] == stack[-2]: 
			answer += 2
			stack.pop()
			stack.pop()

	return answer
