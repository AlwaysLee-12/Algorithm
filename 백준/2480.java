import java.util.*;
import java.io.*;

public class Main
{
    //같은 수가 어떤건지 찾기
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
    //상금 계산
    static int calculMoney(Set<Integer> diceSet, Integer[] diceArr){
        //모두 같은 눈금이라면
        if(diceSet.size() == 1){
            return 10000 + diceArr[0] * 1000;
        }else if (diceSet.size() == 2){ //눈금이 같은게 두 개라면
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
        //주사위 던져 나온 눈금들 집합에 넣어 중복 없애기
        Set<Integer> diceSet = new HashSet<>(Arrays.asList(diceArr));
        //최대값을 찾기위한 정렬
        Arrays.sort(diceArr, Comparator.reverseOrder());
        
        bw.write(String.valueOf(calculMoney(diceSet, diceArr)));
        
        bw.flush();
        bw.close();
    }
}
