from typing import List
import re

# extract first number(NUMBER)
def extract_num(s: str) -> str:
    num_start = re.search("[0-9]", s).start()
    num_end = 0

    for i in range(num_start, len(s)):
        if not s[i].isdigit():
            break
        num_end += 1

    return s[num_start : num_start + num_end]

# extract first str(HEAD)
def extract_str(s: str) -> str:
    return s[0 : re.search("[0-9]", s).start()].lower()


def solution(files: List[str]) -> List[str]:
    answer = []
    # sort files by HEAD and NUMBER
    files.sort(key=lambda a: (extract_str(a), int(extract_num(a))))

    answer = files

    return answer
