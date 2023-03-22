import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Main
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(st.nextToken());
		for(int i = 0; i < num  / 4; i++){
		    bw.write("long ");
		}
		bw.write("int");
 
		bw.flush();
		bw.close();
	}
}
