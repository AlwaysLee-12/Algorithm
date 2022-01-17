from typing import List
from datetime import datetime

def is_matched(m: str, music_score: str)->bool:
	score_list = []
	m_length = len(m.replace('#',''))
  # make music score to list considered '#'
	for i in range(len(music_score)):
		if music_score[i] == '#':
				continue
		else:
			if i + 1 < len(music_score) and music_score[i+1] == '#':
				score_list.append(music_score[i]+music_score[i+1])
			else:
				score_list.append(music_score[i])
		
	for i in range(0, len(score_list)-m_length+1):
		if ''.join(score_list[i:i+m_length]) == m:
			return True

	return False

def calculate_play_time(play_time_start: str, play_time_end: str)->int:
	return (datetime.strptime(play_time_end,"%M:%S") - datetime.strptime(play_time_start,"%M:%S")).seconds

def solution(m: str, musicinfos: List[str])->str:
	answer = ''
	music_info_list = []
	
	# sort music infos order by music play time
	musicinfos.sort(key= lambda a: -calculate_play_time(a.split(',')[0],a.split(',')[1]))

	for music_info in musicinfos:
		music_info = music_info.split(',')
		play_time_start, play_time_end = music_info[0], music_info[1]
		music_name, music_score = music_info[2], music_info[3]
		music_score_list = ''

		# calculate music play time
		play_time = calculate_play_time(play_time_start, play_time_end)
		
		# make music score list
		while play_time > 0:
			for score in music_score:
				if play_time <= 0 and score != '#':
					break

				music_score_list += score

				if score != '#':
					play_time -= 1
				
		music_info_list.append((music_score_list, music_name))

	# find matched music score music 
	for music_info in music_info_list:
		music_score = music_info[0]

		if is_matched(m, music_score):
			answer = music_info[1]
			break
		
	if answer == '':
		answer = "(None)"

	return answer
