from typing import List

# fill block to empty area of it's same col
def move_block(m: int, n: int, board: List[List[str]], erased_block_list: List[List[int]]):
	for row in range(m-1,-1,-1):
		for col in range(n):
			if erased_block_list[row][col] == 1:
				move_row = row - 1
        # find existing block in same col
				while move_row >= 0 and erased_block_list[move_row][col] == 1:
					move_row -= 1
				if move_row >= 0:
					board[row][col] = board[move_row][col]
					board[move_row][col] = 0
					erased_block_list[move_row][col] = 1
				else:
					board[row][col] = 0
				 
def erased_block_count(erased_block_list: List[List[int]])->int:
	count = 0

	for row in erased_block_list:
		for block in row:
			if block == 1:
				count += 1

	return count

def find_erase_block(m: int, n: int, board: List[List[str]], erased_block_list: List[List[int]]):
	for row in range(m-1):
		for col in range(n-1):
      # find 2*2 satistied block check it in erased block list by 1 
			if board[row][col] != 0 and board[row][col] == board[row][col+1] and board[row][col] == board[row+1][col] and board[row][col] == board[row+1][col+1]:
				erased_block_list[row][col] = 1
				erased_block_list[row+1][col] = 1
				erased_block_list[row][col+1] = 1
				erased_block_list[row+1][col+1] = 1

def solution(m: int, n: int, board: List[str])->int:
	answer = 0
	# change str to list
	for row in range(m):
		board[row] = list(board[row])

	while True:
    # make will be erased block list
		erased_block_list = [[0 for _ in range(n)] for _ in range(m)]
    # find will be erased block and check it
		find_erase_block(m, n, board, erased_block_list)
    # count be erased block
		count = erased_block_count(erased_block_list)
		
		if count == 0:
			break
		else:
			answer += count
      # fill block to empty block
			move_block(m, n, board, erased_block_list)
		

	return answer
