from typing import List

def solution(places: List[str])-> List[int]:
	answer = []
	
	for waiting_room in places:
		is_safe = True
		person_list = []
    # extract P's location 
		for row in range(len(waiting_room)):
			for col in range(len(waiting_room[0])):
				if waiting_room[row][col] == "P":
					person_list.append((row,col))
    # get manhathon result of each P
		for i in range(len(person_list)):
			for j in range(i + 1, len(person_list)):
				row1, col1 = person_list[i]
				row2, col2 = person_list[j]

				manhathon = abs(row1 - row2) + abs(col1 - col2)
        # manhathon is 2 case
        # same row, same col, diagnal
        # if two P row locations are same and there is X between them, it is safe
        # if two P col locations are same and there is X between them, it is safe
        # if two P are located diagnal each and there are Xs near by each of P, it is safe
				if manhathon <= 2:
					if manhathon == 2 and row1 == row2 and waiting_room[row1][col2 - 1] == "X":
						continue
					elif manhathon == 2 and col1 == col2 and waiting_room[row2 - 1][col1] == "X":
						continue
					elif manhathon == 2 and row1 != row2 and col1 != col2 and waiting_room[row1][col2] == "X" and waiting_room[row2][col1] == "X":
						continue
					is_safe = False

		if is_safe:
			answer.append(1)
		else:
			answer.append(0)
	
	return answer
