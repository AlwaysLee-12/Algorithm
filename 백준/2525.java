import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cookTime = Integer.parseInt(st.nextToken());
        int total = hour * 60 + minute + cookTime;
        int resultHour = total / 60;
        int resultMinute = total % 60;
        
        if(resultHour > 23){
            resultHour = resultHour - 24 ;
        }
        bw.write(String.valueOf(resultHour) + " ");
        bw.write(String.valueOf(resultMinute));
        
        bw.flush();
        bw.close();
    }
}
