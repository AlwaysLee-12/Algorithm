import java.util.*;
import java.io.*;

public class Main
{
    static int findSame(Integer[] diceArr){
        for(int i = 0; i < diceArr.length; i++){
            for(int j = i + 1; j < diceArr.length; j++){
                if(diceArr[i] == diceArr[j]){
                    return diceArr[i];
                }
            }
        }
        
        return -1;
    }
    
    static int calculMoney(Set<Integer> diceSet, Integer[] diceArr){
        if(diceSet.size() == 1){
            return 10000 + diceArr[0] * 1000;
        }else if (diceSet.size() == 2){
            int sameNum = findSame(diceArr);
            return 1000 + sameNum * 100;
        }else{
            return diceArr[0] * 100;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer[] diceArr = new Integer[3];
        
        int i = 0;
        while(st.hasMoreTokens()){
            diceArr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Set<Integer> diceSet = new HashSet<>(Arrays.asList(diceArr));

        Arrays.sort(diceArr, Comparator.reverseOrder());
        
        bw.write(String.valueOf(calculMoney(diceSet, diceArr)));
        
        bw.flush();
        bw.close();
    }
}
