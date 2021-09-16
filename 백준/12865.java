import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int thingsNum, thingsWeight;
        int[][] thingsInfo;
        int[][] dpTable;

        Scanner scan= new Scanner(System.in);
        thingsNum= scan.nextInt();
        thingsWeight= scan.nextInt();

        thingsInfo= new int[thingsNum+1][2];
        thingsInfo[0][0]= 0;
        for(int i=1; i<=thingsNum; i++){
            thingsInfo[i][0]= scan.nextInt();
            thingsInfo[i][1]= scan.nextInt();
        }

        Arrays.sort(thingsInfo, new Comparator<int[]>(){
            @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[0]==o2[0]) return o1[1]-o2[1];
                    else return o1[0]-o2[0];
                }
            }
        );

        dpTable= new int[thingsNum+1][thingsWeight+1];
        for(int i=0; i<=thingsWeight; i++){
            dpTable[0][i]= 0;
        }
        for(int i=0; i<=thingsNum; i++){
            dpTable[i][0]= 0;
        }
        for(int i=1; i<=thingsWeight; i++){
            for(int j=1; j<=thingsNum; j++){
                if(i<thingsInfo[j][0]){ dpTable[j][i]= dpTable[j-1][i]; } 
                else if(i==thingsInfo[j][0]){ dpTable[j][i]= Math.max(thingsInfo[j][1], dpTable[j-1][i]); }
                else{ dpTable[j][i]= Math.max(dpTable[j-1][i], thingsInfo[j][1]+dpTable[j-1][i-thingsInfo[j][0]]); }                  
            }
        }
        System.out.println(dpTable[thingsNum][thingsWeight]);
    }
}
