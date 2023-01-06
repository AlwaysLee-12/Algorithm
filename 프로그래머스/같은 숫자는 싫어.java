import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        //초기 비교 대상 수 Push
        stack.push(arr[0]);

        for (int num : arr) {
            //연속된 수면, skip
            if (stack.peek().equals(num)) {
                continue;
            }
            //다른 수면, 스택에 있는 비교 대상 수 Pop해 answer에 저장 후, 새로운 비교 대상 수로 교체
            else{
                answer.add(stack.pop());
                stack.push(num);
            }
        }

        //스택에 남아있는 수 Pop
        answer.add(stack.pop());

        return answer;
    }
}

/***
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 * 배열 arr ( 0 < arr.length <= 1,000,000 )
 * arr 원소 크기 ( 0 <= 원소 <= 9 )
 * 배열 arr에서 연속된 숫자는 하나만 남기고 모두 제거 후 return ( 단, 순서는 유지 ) => 의미 : 정렬 X
 */

/**
 * 순차적으로 나아가며, 앞 뒤 수를 비교해 같으면 뒤에꺼 지운다 => 순차 진행 N * 배열 요소 삭제 N => X
 * Stack 또는 Queue를 이용해 비교 대상 수를 넣어놓고 같으면 스킵하고, 다르면 비교 대상 수(기존꺼 Pop or Poll)를 교체해 연속된 수 중 하나만 남기도록 한다 => 순차 진행 N * 요소 삭제 1 => O
 */

/**
 * 1. 빈 Stack이면, Push
 * 2. 같은 수면, pass
 * 3. 다른 수면, Stack Pop 후 새로운 수 Push
 * 4. 마지막 Stack에 남아있는 수 Pop
 */
