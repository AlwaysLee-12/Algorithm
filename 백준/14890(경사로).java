import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static boolean judgePutRunway(boolean[] existenceRunway, int row, int l){
        for(int i = row + 1; i <= row + l; i++){
            if(existenceRunway[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean judgeRoute(int n, int l, int[] map){
        boolean[] existenceRunway = new boolean[n];

        Arrays.fill(existenceRunway, false);
        
        for(int row = 0; row < n - 1; row++){
            //평지
            if(map[row] == map[row + 1]){
                continue;
            }
            //내리막길
            else if(map[row] - map[row + 1] == 1 && row + l < n){
                int sameNums = map[row + 1];

                for(int tmpRow = row + 2; tmpRow <= row + l; tmpRow++){
                    if(sameNums != map[tmpRow]){
                        return false;
                    }
                }

                if(!judgePutRunway(existenceRunway, row, l)){
                    return false;
                }

                for(int tmpRow = row + 1; tmpRow <= row + l; tmpRow++){
                    existenceRunway[tmpRow] = true;
                }
            }
            //오르막길
            else if(map[row] - map[row + 1] == -1 && row - l >= -1){
                int sameNums = map[row];

                for(int tmpRow = row - 1; tmpRow > row - l; tmpRow--){
                    if(sameNums != map[tmpRow]){
                        return false;
                    }
                }

                if(!judgePutRunway(existenceRunway, row - l, l)){
                    return false;
                }

                for(int tmpRow = row - l + 1; tmpRow <= row; tmpRow++){
                    existenceRunway[tmpRow] = true;
                }
            }
            //이동불가
            else{
                return false;
            }
        }

        return true;
    }
    //경로 탐색
    public static int searchRoute(int n, int l, int[][] map){
        int distanceCount = 0;
            
        for(int col = 0; col < n; col++){           
            int[] tempMapRow = map[col].clone();
            int[] tempMapCol = new int[n];
                
            for(int row = 0; row < n; row++){
                tempMapCol[row] = map[row][col];
            }
            
            if(judgeRoute(n,l, tempMapRow)){
                distanceCount += 1;
            }
            if(judgeRoute(n, l, tempMapCol)){
                distanceCount += 1;
            }
        }
        
        return distanceCount;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int l = scan.nextInt();

        int[][] map = new int[n][n];
    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = scan.nextInt();
            }
        }

        System.out.println(searchRoute(n, l, map));
    }
}
