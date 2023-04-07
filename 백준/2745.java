import java.util.*;
import java.io.*;
//수학 
public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int index = 0;
        
        String number = st.nextToken();
        int arithmetic = Integer.parseInt(st.nextToken());
        for(int i = number.length() - 1; i >= 0; i--){
            char a = number.charAt(i); 
            if((int)a >= 65){
                result += (Math.pow(arithmetic, index) * ((int)a - 55));
            }else{
                result += (Math.pow(arithmetic, index) * Integer.parseInt(String.valueOf(a)));
            }
            index += 1;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
