//나의 풀이
import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
       ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int num : arr) {
            if (num % divisor == 0) {
                answer.add(num);
            }
        }

        Collections.sort(answer);

        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }
}

//코드가 간결한 풀이(람다식 사용)
class Solution{
  public int[] solution(int[] arr, int divisor){
    int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).toArray();
    
    Arrays.sort(answer);
    
    if(answer.length == 0){
      answer = new int[] {-1}; 
    }
    
    return answer;
  }
}

/***
 * https://school.programmers.co.kr/learn/courses/30/lessons/12910
 * 배열 arr의 원소 중 divisor로 나누어 떨어진는 값 오름차순 정렬 후 return
 * 나누어 떨어지는 값 없으면 -1 return
 * arr.length > 1, divisor > 0, 배열의 원소중 중복된 값 X
 */

/**
 * 순차적으로 나아가며 배열 arr에서 divisor의 배수인 것을 찾음
 */

/**
 * 1. divisor로 나누어 떨어지는 원소 탐색 후 answer에 담음
 * answer 오름차순 정렬
 * 만약 answer에 원소가 없으면, return -1
 */
