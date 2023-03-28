import java.io.*;
import java.nio.Buffer;
import java.util.*;
//문자열 단순 구현 문제
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int i = scan.nextInt();

        System.out.println(str.charAt(i - 1));
    }
}
