import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] lineArr;
        int result = 0;

        int lineLength = Integer.parseInt(st.nextToken());
        int getLength = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        lineArr = new String[lineLength];
        boolean[] isVisited = new boolean[lineLength];
        for(int i = 0; i < lineLength; i++){
            lineArr[i] = Character.toString(line.charAt(i));
        }

        for(int i = 0; i < lineLength; i++){
            if(lineArr[i].equals("P")){
                boolean flag = false;

                for(int j = getLength; j > 0; j--){
                    if(i - j >= 0 && lineArr[i - j].equals("H") && !isVisited[i - j]){
                        isVisited[i - j] = true;
                        result += 1;
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    continue;
                }
                for(int j = 1; j <= getLength; j++){
                    if(i + j < lineLength && lineArr[i + j].equals("H") && !isVisited[i + j]){
                        isVisited[i + j] = true;
                        result += 1;
                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}

/*
 * 팔의 최대 길이와 로봇의 수가 주어졌을 때, 물건을 집을 수 있는 로봇의 최대 수 구하기
 * 1. 라인 배열을 차례대로 반복
 * 1-2. 현재가 로봇(P)이고, 왼쪽 팔길이 최대부터 왼쪽 - 1 내에 물건이 있으면 해당 로봇 카운트 후 break
 * 1-3. 왼쪽 탐색에서 끝났으면 continue
 * 1-4. 현재가 로봇(P)이고, 오른쪽 팔길이 + 1 부터 최대 팔길이까지 물건이 있으면 해당 로봇 카운트 후 break
 */
