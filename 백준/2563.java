import java.util.*;
import java.io.*;
//이차원 배열을 이용한 단순 구현 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[][] paper = new boolean[100][100];
        int paperCount = Integer.parseInt(st.nextToken());
        int result = 0;
        
        for(int i = 0; i < paperCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken()) - 1;
            int row = Integer.parseInt(st.nextToken()) - 1;

            for(int j = row; j < row + 10; j++){
                for(int k = col; k < col + 10; k++){
                    if(!paper[j][k]){
                        paper[j][k] = true;
                        result += 1;
                    }
                }
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
