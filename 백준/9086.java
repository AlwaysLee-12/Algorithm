import java.io.*;
import java.nio.Buffer;
import java.util.*;
//문자열 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCount = scan.nextInt();
        for (int i = 0; i < inputCount; i++) {
            String str = scan.next();
            int length = str.length();

            bw.write(String.valueOf(str.charAt(0)) + String.valueOf(str.charAt(length - 1)) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
