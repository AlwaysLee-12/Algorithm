import java.io.*;
import java.nio.Buffer;
import java.util.*;
//배열을 이용한 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int basketCount = Integer.parseInt(st.nextToken());
        int methodCount = Integer.parseInt(st.nextToken());
        int[] basketArr = new int[basketCount];

        for (int i = 0; i < methodCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int fromBasket = Integer.parseInt(st.nextToken());
            int toBasket = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());

            for (int j = fromBasket - 1; j < toBasket; j++) {
                basketArr[j] = ballNum;
            }
        }

        for (int i = 0; i < basketCount; i++) {
            bw.write(String.valueOf(basketArr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}
