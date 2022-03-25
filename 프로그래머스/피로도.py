from cProfile import label
from typing import Dict, List
import heapq
from bisect import bisect_left, bisect_right
from collections import defaultdict, deque
import copy
import collections
from itertools import combinations
import re
from datetime import datetime
import math

answer = 0

def dfs(k: int, dungeons: List[List[int]], visited: List, count: int):
    global answer
    
    if count > answer:
        answer = count

    for dungeon in dungeons:
        if k >= dungeon[0] and dungeon not in visited:
            visited.append(dungeon)
            dfs(k - dungeon[1], dungeons, visited, count + 1)
            visited.pop()

def solution(k: int, dungeons: List[List[int]])->int:
    global answer
    
    candidate = []

    dfs(k, dungeons, [], 0)

    return answer
