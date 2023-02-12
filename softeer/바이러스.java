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
*/
