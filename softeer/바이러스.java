import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        for(int i = 1; i <= n; i++){
            k *= p;
            k %= 1000000007;
        }

        bw.write(String.valueOf(k));
        bw.flush();
        bw.close();
    }
}

/*
 * K개의 바이러스의 증가율이 P일 때, N초 후의 바이러스의 수에서 1000000007로 나눈 나머지 구하기
 * 1. K * P를 N번 반복
 * 2. long 범위를 넘어갈 수 있으니 문제에 주어진대로 반복시마다 K * P 값을 1000000007로 나눈 나머지 구하고 거기에 P 
 * K * P % 1000000007 = (K % 1000000007) * (P % 1000000007)인 이유
 * K = kQ + r1(Q는 나눌 수, rn은 나머지), P = pQ + r2라고 했을 때,
 * K*P = kQ^2 + kr2Q + pr1Q + r1r2 => r1r2의 앞부분은 Q로 나눠지기 때문에 몫이고, r1r2 부분이 나머지
 * 즉, K 곱 P를 Q로 나눈 나머지는 K를 Q로 나눈 나머지와 P를 Q로 나눈 나머지를 곱한 
*/
