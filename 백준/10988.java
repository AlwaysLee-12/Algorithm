import java.io.*;
import java.nio.Buffer;
import java.util.*;
//스택과 큐를 이용한 팰린드롬 확인 문제
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Stack<String> stack = new Stack<>();
        Queue<String> q = new LinkedList<>();
        int result = 1;

        for (int i = 0; i < str.length(); i++) {
            stack.push(String.valueOf(str.charAt(i)));
            q.add(String.valueOf(str.charAt(i)));
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(q.poll())) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }
}
