import java.io.*;
//문자열 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
