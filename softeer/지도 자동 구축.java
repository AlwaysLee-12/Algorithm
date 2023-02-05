import java.util.*;
import java.io.*;
import java.lang.Math;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int stage = Integer.parseInt(br.readLine());
        long dotCount = (long)Math.pow(Math.pow(2, stage) + 1, 2);

        bw.write(String.valueOf(dotCount));

        bw.flush();
        bw.close();
    }
}

/*
 * 단계별 규칙적으로 증가하는 점의 개수 구하는 문제
 * 1. 단계 입력
 * 2. (2^입력한 단계 + 1)^2 계산 후 출력
*/
