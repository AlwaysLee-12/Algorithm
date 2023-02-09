import java.util.*;
import java.io.*;


public class Main
{
    static Queue<Integer[]> aQ = new LinkedList<>();
    static Queue<Integer[]> bQ = new LinkedList<>();

    static int countOne(Integer[] arr){
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                result += 1;
            }
        }
        
        return result;
    }

    static int compare(Integer[] aList, Integer[] bList){
        int result = 0;

        for(int i = 0; i < aList.length; i++){
            if(aList[i] != bList[i]){
                result += 1;
            }
        }

        return result;
    }

    static void insertToQueue(Queue<Integer[]> q, Integer[][] eachNumSwitchStateArr, List<Integer> valList){
        for(Integer val : valList){
            q.offer(eachNumSwitchStateArr[val]);
        }
    }

    static List<Integer> getEachDigitVal(int num){
        List<Integer> arr = new ArrayList<>();

        while(num > 0){
            int val = num % 10;

            arr.add(val);
            num /= 10;
        }

        return arr;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[][] eachNumSwitchStateArr = {{1,1,1,0,1,1,1}, {0,0,1,0,0,0,1}, {0,1,1,1,1,1,0}, {0,1,1,1,0,1,1}, {1,0,1,1,0,0,1}, {1,1,0,1,0,1,1}, {1,1,0,1,1,1,1}, {1,1,1,0,0,0,1}, {1,1,1,1,1,1,1}, {1,1,1,1,0,1,1}};
    
        int testCaseCount = Integer.parseInt(st.nextToken());

        for(int i = 0; i < testCaseCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int switchPushCount = 0;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> aValList = getEachDigitVal(a);
            List<Integer> bValList = getEachDigitVal(b);

            insertToQueue(aQ, eachNumSwitchStateArr, aValList);
            insertToQueue(bQ, eachNumSwitchStateArr, bValList);

            if(aQ.size() == bQ.size()){
                while(bQ.size() > 0){
                    switchPushCount += compare(aQ.poll(), bQ.poll());
                }
            }else if(aQ.size() > bQ.size()){
                while(bQ.size() > 0){
                    switchPushCount += compare(aQ.poll(), bQ.poll());
                }

                while(aQ.size() > 0){
                    switchPushCount += countOne(aQ.poll());
                }
            }else{
                while(aQ.size() > 0){
                    switchPushCount += compare(aQ.poll(), bQ.poll());
                }

                while(bQ.size() > 0){
                    switchPushCount += countOne(bQ.poll());
                }
            }

            bw.write(String.valueOf(switchPushCount) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

/*
 * 전광판 숫자 변경 시 각 칸 별 스위치 최소 몇 번 눌러야 변경 가능한 지 구하기
 * 서로 다른 두 숫자 A, B의 자리 수 1이상 5이하, 숫자는 0으로 시작하지 않음
 * 1. 0~9까지 전광판 각 칸 별 스위치 상태 배열 arr 생성
 * 2. A, B 각각 자리수 만큼 arr을 이용해 각 자리수 별 스위치 상태 배열 생성(Queue)
 * 3. A, B의 자리수가 같을 때, A의 자리수가 더 많을 때, B의 자리수가 더 많을 떄 경우 분기 처리
 * 3-1. A, B 자리수 값을 때, 각 자리수 배열에서 다른 부분이 있으면 스위치 누르는 횟수 카운트 증가
 * 3-2. A의 자리수가 더 크다면, B 자리수에 맞춰 3-1 수행 후 마지막 A의 스위치 상태 배열에서 켜져 있는 스위치 개수 카운트
 * 3-3. 3-2의 과정을 B의 기준에서 수행
*/
