import java.io.*;
import java.nio.Buffer;
import java.util.*;
//배열을 이용한 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> stdList = new ArrayList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 28; i++) {
            stdList.add(scan.nextInt());
        }

        for (int i = 1; i <= 30; i++) {
            if (!stdList.contains(i)) {
                bw.write(i + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
