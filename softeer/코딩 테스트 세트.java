import java.util.*;
import java.io.*;


public class Main
{
    static int levelCount;
    static long[] levelFixedProblems;
    static long[] levelNotFixedProblems;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //입력 테스트 세트 수가 가능한 테스트 세트인지
    static boolean isPossible(long testSetCount){
        //현 시점까지의(현 레벨) 가능한 테스트 세트 수 리스트
        long[] possiCurLevCoutArr = new long[levelCount];
        possiCurLevCoutArr[0] = levelFixedProblems[0];

        for(int i = 0; i < levelCount - 1; i++){
            //현재 레벨의 문제 수가 입력 테스트 세트 수보다 크거나 같으면 뒤 레벨에 확정 안된 레벨의 테스트 수 다 넘겨줌
            if(possiCurLevCoutArr[i] >= testSetCount){
                possiCurLevCoutArr[i + 1] = levelFixedProblems[i + 1] + levelNotFixedProblems[i];
            }
            //현재 레벨의 문제 수에 확정 안된 레벨의 테스트 수 더한게 입력 테스트 세트 수보다 크거나 같으면, 앞에 레벨에서 먹고 남은 거 뒤에 줌
            else if(possiCurLevCoutArr[i] + levelNotFixedProblems[i] >= testSetCount){ 
                possiCurLevCoutArr[i + 1] = levelFixedProblems[i + 1] + 
                (possiCurLevCoutArr[i] + levelNotFixedProblems[i] - testSetCount);
            }else{
                return false;
            }
        }
        //현 시점까지의(현 레벨) 가능한 테스트 세트 수 리스트 마지막 값이 입력 테스트 세트 수보다 크거나 같으면 입력 테스트 세트 수는 가능하다고 판단
        if(possiCurLevCoutArr[levelCount - 1] >= testSetCount){
            return true;
        }
        return false;
    }

    static void binarySearch(long start, long end) throws IOException{
        //베이스 케이스. 최대 테스트 세트 개수 출력
        if(start == end){
            bw.write(String.valueOf(start));
            bw.newLine();
            return;
        }

        long mid = (start + end + 1) / 2;
        //해당 테스트 세트 수가 나올 수 있다면 오른쪽 탐색
        if(isPossible(mid)){
            binarySearch(mid, end);
        }else{ //아니면 왼쪽 탐색
            binarySearch(start, mid - 1);
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        levelCount = Integer.parseInt(st.nextToken());
        int scenarioCount = Integer.parseInt(st.nextToken());
        //테스트 케이스 별 처리
        for(int i = 0 ; i < scenarioCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            levelFixedProblems = new long[levelCount * 2];
            levelNotFixedProblems = new long[levelCount * 2];
            //홀수 인덱스인 것들은 레벨이 결정된 문제 세트에 넣고, 짝수 인덱스인 것들은 레벨이 결정되지 않은 세트에 넣음 
            for(int j = 0; j < levelCount - 1; j++){
                levelFixedProblems[j] = Long.parseLong(st.nextToken());
                levelNotFixedProblems[j] = Long.parseLong(st.nextToken());
            }
            //각 마지막 부분 추가
            levelFixedProblems[levelCount - 1] = Long.parseLong(st.nextToken());
            levelNotFixedProblems[levelCount - 1] = 0L;
            //최대 테스트 세트 개수 안에서 이진 탐색
            binarySearch(0L, 2000000000000L);
        }

        bw.flush();
        bw.close();
    }
}
