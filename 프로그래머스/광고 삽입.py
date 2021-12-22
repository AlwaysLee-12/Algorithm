from typing import List

def solution(play_time: str, adv_time: str, logs: List[str]) -> str:
    answer = ""
    accumulate_sum_list = []
    # make adv time to second
    splitted_adv_time = adv_time.split(":")
    adv_sec = (
        int(splitted_adv_time[0]) * 3600
        + int(splitted_adv_time[1]) * 60
        + int(splitted_adv_time[2])
    )
    # proccess exception when play time same with adv time 
    if play_time == adv_time:
        return "00:00:00"
    # make play time to second
    splitted_play_time = play_time.split(":")
    play_sec = (
        int(splitted_play_time[0]) * 3600
        + int(splitted_play_time[1]) * 60
        + int(splitted_play_time[2])
    )
    # initialize accumulate sum list
    for sec in range(play_sec + 1):
        accumulate_sum_list.append(0)
    # insert to accumulate list about viwer info
    # plus 1 when 1 viewer is in, minus 1 when 1 viwer is out
    for log in logs:
        splitted_log = log.split("-")
        start_time = splitted_log[0]
        end_time = splitted_log[1]

        splitted_start_time = start_time.split(":")
        splitted_end_time = end_time.split(":")

        start_sec = (
            int(splitted_start_time[0]) * 3600
            + int(splitted_start_time[1]) * 60
            + int(splitted_start_time[2])
        )
        end_sec = (
            int(splitted_end_time[0]) * 3600
            + int(splitted_end_time[1]) * 60
            + int(splitted_end_time[2])
        )

        accumulate_sum_list[start_sec] += 1
        accumulate_sum_list[end_sec] -= 1
    # execute double accumulate sum
    for sec in range(1, len(accumulate_sum_list)):
        accumulate_sum_list[sec] += accumulate_sum_list[sec - 1]

    for sec in range(1, len(accumulate_sum_list)):
        accumulate_sum_list[sec] += accumulate_sum_list[sec - 1]
    # get biggest accumulate run time
    final_accumulate_run_time= accumulate_sum_list[adv_sec]
    final_adv_sec= 0
    for adv_end_sec in range(adv_sec+1, play_sec + 1):
        accumulate_run_time = (
            accumulate_sum_list[adv_end_sec]
            - accumulate_sum_list[adv_end_sec - adv_sec]
        )

        if accumulate_run_time > final_accumulate_run_time:
            final_accumulate_run_time = accumulate_run_time
            final_adv_sec = adv_end_sec - adv_sec + 1
    # make final adv second to time format
    adv_hour = final_adv_sec // 3600
    final_adv_sec %= 3600
    adv_minute = final_adv_sec // 60
    final_adv_sec %= 60
    adv_second = final_adv_sec

    answer = (
        str(adv_hour).zfill(2)
        + ":"
        + str(adv_minute).zfill(2)
        + ":"
        + str(adv_second).zfill(2)
    )

    return answer
