import java.util.*;
import java.io.*;
//배열(인덱스 조정) 및 반복문을 이용한 구현 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] basketArr;
        
        int basketCount = Integer.parseInt(st.nextToken());
        int methodCount = Integer.parseInt(st.nextToken());
        basketArr = new int[basketCount];
        
        for(int i = 0; i < basketCount; i++){
            basketArr[i] = i + 1;
        }
        for(int i = 0; i < methodCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            
            int[] tempArr = basketArr.clone();
            for(int j = mid - 1; j < end; j++){
                tempArr[begin - 1 + j - (mid - 1)] = basketArr[j];
            }
            for(int j = begin - 1; j < mid - 1; j++){
                tempArr[end - mid + begin + j - (begin - 1)] = basketArr[j];
            }
            basketArr = tempArr;
        }
        
        for(int i = 0; i < basketCount; i++){
            bw.write(basketArr[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
