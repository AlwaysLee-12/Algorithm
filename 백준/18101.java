import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int buddhism = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(buddhism - 543));
        bw.flush();
        bw.close();
    }
}
