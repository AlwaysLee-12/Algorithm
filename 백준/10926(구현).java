import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String alreadyExistId = st.nextToken();

        bw.write(alreadyExistId + "??!");
        bw.flush();

        bw.close();
    }
}

/***
 * https://www.acmicpc.net/problem/10926
 * 입력된 문자열(length <= 50)에 ??! 붙여 출력
 */
