import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] secretKeyArr;
        int[] userInputArr;
        boolean flag = true;

        int secretKeyLength = Integer.parseInt(st.nextToken());
        int userInputLength = Integer.parseInt(st.nextToken());
        int buttonCount = Integer.parseInt(st.nextToken());

        secretKeyArr = new int[secretKeyLength];
        userInputArr = new int[userInputLength];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < secretKeyLength; i++){
            secretKeyArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < userInputLength; i++){
            userInputArr[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i = 0; i <= userInputLength - secretKeyLength; i++){
            flag = true;
            for(int j = 0; j < secretKeyLength; j++){
                if(userInputArr[i + j] != secretKeyArr[j]){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                break;
            }
        }

        if(flag){
            bw.write("secret");
        }else{
            bw.write("normal");
        }

        bw.flush();
        bw.close();
    }
}

/*
 * 입력 배열 내 특정 순서를 가진 숫자들이 포함되어 있는지 구하기
 * 1. 기준 숫자 배열 입력, 탐색 대상 숫자 배열 입력
 * 2. 탐색 대상 숫자 배열 완전 탐색(인덱스는 0부터 탐색 대상 숫자 배열 길이 - 기준 숫자 배열 길이)
 * 3. 기준 숫자 배열과 일치할때까지(일치하면, 반복문 break)
*/
