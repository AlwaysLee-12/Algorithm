import java.util.*;
import java.io.*;
//단순 구현 문제
public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float sumAll = 0.0f;
        float creditSum = 0.0f;
        Map<String, Float> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5f);
        gradeMap.put("A0", 4.0f);
        gradeMap.put("B+", 3.5f);
        gradeMap.put("B0", 3.0f);
        gradeMap.put("C+", 2.5f);
        gradeMap.put("C0", 2.0f);
        gradeMap.put("D+", 1.5f);
        gradeMap.put("D0", 1.0f);
        gradeMap.put("F", 0.0f);
        
        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String subject = st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            
            if(!grade.equals("P")){
                sumAll += (credit * gradeMap.get(grade));
                creditSum += credit;
            }
        }
        
        bw.write(String.valueOf(sumAll / creditSum));
        bw.flush();
        bw.close();
    }
}
