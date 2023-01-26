import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCount = Integer.parseInt(st.nextToken());
        int[] arr = new int[numCount];
        for (int i = 0; i < numCount; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < numCount; i++) {
            bw.write(String.valueOf(arr[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}

/***
 * https://www.acmicpc.net/problem/2750
 * N(1 <= N <= 1000)개의 수 오름차순 정렬
 */
