from typing import List

def solution(cacheSize: int, cities: List[str])->int:
	answer = 0
	cache_list = []
  # if cache size is 0, just calculated return run time
	if cacheSize == 0:
		return 5 * len(cities)
  # chage to lowwer str of each city
	for city_i in range(len(cities)):
		cities[city_i] = cities[city_i].lower() 
  # calculate run time. if city in cache list, add run time +1 and move it to forefront of list
  # if not, pop at the back city of the list, and insert new city to forefront of list and add +5
	for city in cities:
		if city in cache_list:
			city_index_in_list = cache_list.index(city)
			cache_list.insert(0, cache_list.pop(city_index_in_list))
			answer += 1
		else:
			if len(cache_list) == cacheSize:
				cache_list.pop()
			cache_list.insert(0, city)
			answer += 5
	
	return answer
