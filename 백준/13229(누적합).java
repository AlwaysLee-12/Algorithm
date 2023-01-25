import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int arrSize = Integer.valueOf(st.nextToken());
        int[] arr = new int[arrSize + 1];
        int[] cumulativeSumArr = new int[arrSize + 1];

        //누적합 배열 생성
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= arrSize; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            cumulativeSumArr[i] = cumulativeSumArr[i - 1] + arr[i];
        }

        //구간의 합 계산(total번 반복)
        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            result[i] = cumulativeSumArr[end] - cumulativeSumArr[start - 1];
        }

        for (int i = 0; i < total; i++) {
            bw.write(String.valueOf(result[i]) + "\n");
        }
        bw.flush();

        bw.close();
    }
}

/***
 * https://www.acmicpc.net/problem/13229
 * 배열의 크기 n(1 <= n <= 100000), 반복 횟수 m(최대 10000), 시작 인덱스 start, 끝 인덱스 end(0 ~ 9)
 * 배열 n이 주어졌을 때 구간 별 합(start~end)을 m번 구하는 문제
 */

/**
 * 배열의 start 부터 end까지 다 더한다 + m번 반복 => O(NM) => 시간 초과
 * 누적합: 누적합 배열을 만들어 누적합 배열의 end에서 start-1을 뺀다 => O(M)
 */

/**
 * 1. 누적합 배열 생성
 * 2. 누적합 배열[end] - 누적합 배열[start - 1] return
 */
