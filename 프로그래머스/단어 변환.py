from typing import List
from collections import deque

def solution(begin: str, target: str, words: List[str]) -> int:
    answer = 0
    words = deque(words)
    bfs_queue = deque()
    adjacent_list = {}
    is_visited = {}

    # if begin is not in words, append to words
    if begin not in words:
        words.appendleft(begin)
    # initialize adjacent list and visit flag list
    for i in range(len(words)):
        adjacent_list[words[i]] = []
        is_visited[words[i]] = False
    # make adjacent list(if it is possible to changing to other word, add to adjacent list)
    for i in range(len(words) - 1):
        for j in range(i + 1, len(words)):
            diff_char_count = 0
            for first_char, second_char in zip(words[i], words[j]):
                if first_char != second_char:
                    diff_char_count += 1
            if diff_char_count == 1:
                adjacent_list[words[i]].append(words[j])
                adjacent_list[words[j]].append(words[i])
    # find target by bfs
    bfs_queue.append((begin, 0))
    is_visited[begin] = True
    while bfs_queue:
        searching_word, changing_count = bfs_queue[0][0], bfs_queue.popleft()[1]
        if searching_word == target:
            answer = changing_count
        for word in adjacent_list[searching_word]:
            if not is_visited[word]:
                is_visited[word] = True
                bfs_queue.append((word, changing_count + 1))

    return answer
