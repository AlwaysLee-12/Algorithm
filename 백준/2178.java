import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String mazeInput;
        String[] tempInput= new String[2];
        int row, col; 
        Deque<List<Integer>> bfsRoute= new LinkedList<>();
        boolean[][] isVisited;
        int[][] maze;
        int[] searchX= {-1,0,1,0};
        int[] searchY= {0,1,0,-1};

        tempInput= (br.readLine()).split(" ");
        row= Integer.parseInt(tempInput[0]);
        col= Integer.parseInt(tempInput[1]);
        maze= new int[row][col];
        isVisited= new boolean[row][col];

        for(int i=0; i<row; i++){
            mazeInput= br.readLine();
            for(int j=0; j<col; j++){
                maze[i][j]= Character.getNumericValue(mazeInput.charAt(j));
            }
        }

        bfsRoute.add(new ArrayList<>());
        bfsRoute.peekFirst().add(0);
        bfsRoute.peekFirst().add(0);
        while(!bfsRoute.isEmpty()){
            int currentX= bfsRoute.peekFirst().get(0);
            int currentY= bfsRoute.pollFirst().get(1);
            isVisited[currentX][currentY]= true;
            for(int i=0; i<searchX.length; i++){
                int possibleX= currentX+searchX[i];
                int possibleY= currentY+searchY[i];
                if(possibleX>=0 && possibleY>=0 && possibleX<=row-1 && possibleY<=col-1){
                    if(maze[possibleX][possibleY]==1 && !isVisited[possibleX][possibleY]){
                        bfsRoute.add(new ArrayList<>());
                        bfsRoute.peekLast().add(possibleX);
                        bfsRoute.peekLast().add(possibleY);
                        maze[possibleX][possibleY]= maze[currentX][currentY]+1;
                    }
                }
            }
        }
        System.out.println(maze[row-1][col-1]);
    }
}
