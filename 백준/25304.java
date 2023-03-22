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
		int result = 0;
 
		int total = Integer.parseInt(st.nextToken());
 
		st = new StringTokenizer(br.readLine(), " ");
		int kindCount = Integer.parseInt(st.nextToken());
 
		for(int i = 0; i < kindCount; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int price = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
 
			result += (price * count);
		}
 
		if(result == total){
			bw.write("Yes");
		}else{
			bw.write("No");
		}
 
		bw.flush();
		bw.close();
	}
}
