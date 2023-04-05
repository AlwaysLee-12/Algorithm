import java.util.*;
import java.io.*;
//ArrayList와 이차원 배열을 활용한 문제
public class Main
{
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<ArrayList<String>> arr = new ArrayList<>();
        int len = 0;

        for(int i = 0; i < 5; i++){
            arr.add(new ArrayList<String>());
        }
        
        for(int i = 0; i < 5; i++){
            String in = scan.nextLine();
            
            for(int j = 0; j < in.length(); j++){
                arr.get(i).add(String.valueOf(in.charAt(j)));
            }
            if(arr.get(i).size() > len){
                len = arr.get(i).size();
            }
        }
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 5; j++){
                if(i < arr.get(j).size()){
                    bw.write(arr.get(j).get(i));
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
