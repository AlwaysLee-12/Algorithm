import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int studentCount = Integer.parseInt(st.nextToken());
        int sectionCount = Integer.parseInt(st.nextToken());

        int[] accumulatedSum = new int[studentCount];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < studentCount; i++){
            if(i == 0){
                accumulatedSum[i] = Integer.parseInt(st.nextToken());
            }else{
                accumulatedSum[i] = accumulatedSum[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < sectionCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int firstSection = Integer.parseInt(st.nextToken());
            int secondSection = Integer.parseInt(st.nextToken());

            if(firstSection == 1){
                bw.write(String.format("%.2f", (double)accumulatedSum[secondSection - 1] / (secondSection - firstSection + 1)));
            }else{
                bw.write(String.format("%.2f", (double)(accumulatedSum[secondSection - 1] - accumulatedSum[firstSection - 2]) / (secondSection - firstSection + 1)));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
/*
 * 구간별 학생들의 평균을 구하는 문제(누적합)
 * 1. 학생들의 점수가 담긴 배열에 대한 누적합 생성
 * 2. 주어진 구간들을 돌면서(n~m) 
 * 2.1. n이 첫 번째 인덱스 이면, 누적합[m - 1] / m - n + 1로 평균 구하고
 * 2.2. 그렇지 않으면, 누적합[m - 1] - 누적합[n - 2] / m - n + 1로 평균 구함
 * 3. 평균들 출력 버퍼에 담아 한번에 
 */
