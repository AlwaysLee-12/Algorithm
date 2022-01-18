from typing import List

def calculate_n_notation(notation: int, number: int) -> str:
    # A ASCII 65
    if number == 0:
        return "0"

    result = ""
    # make number to n notation number
    while number > 0:
        modulo_result = number % notation
        # if modulo result is bigger or equal than 10
        # replace it to A, B, C....
        if modulo_result >= 10:
            modulo_result = chr(modulo_result + 55)
        
        result += str(modulo_result)
        number = number // notation
    # reverse the result
    return result[::-1]


def solution(n: int, t: int, m: int, p: int) -> str:
    answer = ""
    total_num = t * m - (m - p)
    correct_list = []
    # make correct list to shout out
    num = 0
    while len(correct_list) < total_num:
        formatted_num = calculate_n_notation(n, num)

        for fn in formatted_num:
            correct_list.append(fn)

        num += 1
    # make Tube's correct list to win the game
    i = p
    while len(answer) < t:
        answer += correct_list[i - 1]
        i += m

    return answer
