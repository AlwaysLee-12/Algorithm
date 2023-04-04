import java.util.*;
import java.io.*;
//이차원 배열을 이용 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[row][col];
        int[][] arr2 = new int[row][col];
        
        for(int i = 0; i < row * 2; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < col; j++){
                if(i < row){
                    arr1[i][j] = Integer.parseInt(st.nextToken());
                }else{
                    arr2[i - row][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                bw.write(String.valueOf(arr1[i][j] + arr2[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
