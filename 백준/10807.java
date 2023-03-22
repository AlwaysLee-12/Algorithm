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
		List<Integer> arr;
		
		int numCount = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>(numCount);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < numCount; i++){
		    arr.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int targetNum = Integer.parseInt(st.nextToken());
    
    bw.write(String.valueOf(Collections.frequency(arr, targetNum)));
		bw.flush();
		bw.close();
	}
}
