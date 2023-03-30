import java.io.*;
import java.util.*;
//배열을 이용한 단순 구현 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chessArr = {1, 1, 2, 2, 2, 8};
        
        for(int i = 0; i < chessArr.length; i++){
            bw.write(String.valueOf(chessArr[i] - Integer.parseInt(st.nextToken())) + " ");
        }
        
        bw.flush();
        bw.close();
    }
}
