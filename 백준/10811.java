import java.io.*;
import java.nio.Buffer;
import java.util.*;
//배열과 스택을 이용한 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        int[] basketArr;
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int basketCount = Integer.parseInt(st.nextToken());
        basketArr = new int[basketCount];
        for (int i = 0; i < basketCount; i++) {
            basketArr[i] = i + 1;
        }
        int methodCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < methodCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            for (int j = from - 1; j < to; j++) {
                stack.push(basketArr[j]);
            }
            for (int j = from - 1; j < to; j++) {
                basketArr[j] = stack.pop();
            }
        }

        for (int i = 0; i < basketCount; i++) {
            bw.write(String.valueOf(basketArr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}
