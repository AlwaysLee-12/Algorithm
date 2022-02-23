from typing import List
from collections import Counter
import re

def solution(s: str)-> List[int]:
	answer = []
	
  # extract digit by regex
	s = Counter(re.findall('[0-9]+', s))

  # sort s by most count
	s = sorted(s.items(), key= lambda item: item[1], reverse= True)

  # invert type to int and insert s's key to answer 
	[answer.append(int(i[0])) for i in s]

	return answer
