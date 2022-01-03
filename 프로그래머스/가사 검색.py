# ? 를 각각 'a'와 'z'로 채워 words 또는 reversed words 배열에 들어간다면 몇 번째에 위치할 지를 구해야 함
# bisect 이용 froaa, frozz가 있을 수도 있기에 bisect_left와 bisect_right를 같이 사용
# 문자열의 길이를 key로 한 dict를 생성(같은 길이끼리 묶음)
from typing import List
from bisect import bisect_left, bisect_right
import copy
import collections

def solution(words:List[str], queries:List[str])->List[int]:
	answer = []
	reversed_words_dict = collections.defaultdict(list)
	words_dict = collections.defaultdict(list)
  # make dictionary each key is word's length
	for word in words:
		words_dict[len(word)].append(word)
		reversed_words_dict[len(word)].append(word[::-1])
  # sort them by alphabet order
	for key in words_dict.keys():
		words_dict[key].sort()
		reversed_words_dict[key].sort()
  # count key word count
	for query in queries:
		query_filled_a = copy.copy(query)
		query_filled_z = copy.copy(query)
		# fill the question mark part with 'a' and 'z'
		query_filled_a = query.replace('?','a')
		query_filled_z = query.replace('?','z')
    # if question mark is in front
		if query[0]=='?':
      # reverse filled 'a', 'z' variable
			query_filled_a = query_filled_a[::-1]
			query_filled_z = query_filled_z[::-1]
      # find filled 'a' variable's index number when it will be inserted in reversed words by bisect_left
			binary_search_result_filled_a = bisect_left(reversed_words_dict[len(query)], query_filled_a)
      # find filled 'z' variable's index number when it will be inserted in reversed words by bisect_right
			binary_search_result_filled_z = bisect_right(reversed_words_dict[len(query)], query_filled_z)
    # if question mark is in back
		else:
			binary_search_result_filled_a = bisect_left(words_dict[len(query)], query_filled_a)
			binary_search_result_filled_z = bisect_right(words_dict[len(query)], query_filled_z)

		answer.append(binary_search_result_filled_z - binary_search_result_filled_a)

	return answer
