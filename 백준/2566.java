import java.util.*;
import java.io.*;
//이차원 배열 활용 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = -1;
        int maxRow = 0;
        int maxCol = 0;
        
        for(int i = 0 ; i < 9; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                int currentNum = Integer.parseInt(st.nextToken());
                if(currentNum > max){
                    max = currentNum;
                    maxRow = i + 1;
                    maxCol = j + 1;
                }
            }
        }
        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(maxRow) + " " + String.valueOf(maxCol));
        bw.flush();
        bw.close();
    }
}
