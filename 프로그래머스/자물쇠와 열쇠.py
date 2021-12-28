from typing import List
import copy

# spin the key(90 degree)
def spin(key:List[int])->List[int]:
	key_side_len= len(key)
	changing_indexs= []

	for row in range(key_side_len):
		for col in range(key_side_len):
			if key[row][col]==1:
				key[row][col]=0
				changing_indexs.append((col,key_side_len-1-row))

	for i in changing_indexs:
		key[i[0]][i[1]]=1

	return key

def solution(key:List[int], lock:List[int])->bool:
	answer = False
	lock_side_len= len(lock)
	key_side_len= len(key)

	for _ in range(4):
    # spin the key(90 dgree)
		key= spin(key)
    # do all case to check if key can unlock the lock(move the spinned key)
		for row in range(lock_side_len+key_side_len-1):
			for col in range(lock_side_len+key_side_len-1):
				temp_lock= copy.deepcopy(lock)
        # find overlapped part and add them
				key_row= key_side_len-1
				for lock_r_i in range(row,-1,-1):
					key_col= key_side_len-1
					for lock_c_i in range(col,-1,-1):
						if lock_c_i<lock_side_len and lock_r_i<lock_side_len and key_col>=0 and key_row>=0:
							temp_lock[lock_r_i][lock_c_i]+=key[key_row][key_col]
						key_col-=1
					key_row-=1
        # verify if current case is satisfied(can unlock the lock)
				result_flag= True
				for r in range(lock_side_len):
					for c in range(lock_side_len):
						if temp_lock[r][c]==0 or temp_lock[r][c]==2:
							result_flag= False

				if result_flag:
					return True

	return answer
