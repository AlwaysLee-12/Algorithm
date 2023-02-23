import java.util.*;
import java.io.*;


public class Main
{
    static int[] dRow = {0, -1, 0, 1};
    static int[] dCol = {-1, 0, 1, 0};
    static String[] dDirection = {"<", "^", ">", "v"};
    static String result = "";

    //출발지 선정
    static boolean isPossibleStartPoint(String[][] map, int row, int col){
        int sharpCount = 0;

        //현재 map에서의 위치에 #이 있으면서, 인접해 있는 #이 한 개인 경우 출발지로 선정
        if(map[row][col].equals("#")){
            for(int i = 0; i < 4; i++){
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                if(nextRow >= 0 && nextCol >= 0 && 
                    nextRow < map.length && nextCol < map[0].length &&
                    map[nextRow][nextCol].equals("#")){
                        sharpCount += 1;
                    }
            }

            if(sharpCount == 1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //방향을 바꾸게 될 경우 오른쪽 회전인지 왼쪽 회전인지 알려줌
    static String setDirection(String currentDirection, String nextDirection){
        if(currentDirection.equals(">") && nextDirection.equals("v") ||
            currentDirection.equals("v") && nextDirection.equals("<") ||
            currentDirection.equals("<") && nextDirection.equals("^") ||
            currentDirection.equals("^") && nextDirection.equals(">")){
                return "R";
            }else{
                return "L";
            }
    }

    //지나간 경로 dfs를 이용한 탐색
    static void dfs(String[][] map, boolean[][] isVisited, int currentRow, int currentCol, String direction){
        //베이스 케이스(인덱스 범위 넘어가면 종료)
        if(currentRow < 0 || currentCol < 0 &&
            currentRow >= map.length && currentCol >= map[0].length){
            return;
        }

        isVisited[currentRow][currentCol] = true;

        for(int i = 0; i < 4; i++){
            int nextRow = currentRow + dRow[i];
            int nextCol = currentCol + dCol[i];
            String nextDirection = dDirection[i];
            //다음 방문할 곳이 인덱스 범위를 넘어가지 않으면서, 방문한 곳이 아닐 경우 진행 + #인 경우
            if(nextRow >= 0 && nextCol >= 0 &&
                nextRow < map.length && nextCol < map[0].length &&
                map[nextRow][nextCol].equals("#") && !isVisited[nextRow][nextCol]){
                    //진행 방향이 이전과 같다면 그대로 진행(왼쪽 + 2, 오른쪽 + 2, 위 + 2, 아래 + 2. 경우에 따라)
                    if(direction.equals(nextDirection)){
                        isVisited[nextRow][nextCol] = true;
                        result += "A";
                        if(i == 2){
                            dfs(map, isVisited, currentRow, currentCol + 2, nextDirection);
                        }else if(i == 0){
                            dfs(map, isVisited, currentRow, currentCol - 2, nextDirection);
                        }else if(i == 1){
                            dfs(map, isVisited, currentRow - 2, currentCol, nextDirection);
                        }else{
                            dfs(map, isVisited, currentRow + 2, currentCol, nextDirection);
                        }
                    }else{
                        //다르다면, 다음 방향 설정
                        result += setDirection(direction, nextDirection);
                        dfs(map, isVisited, currentRow, currentCol, nextDirection);
                    }
                }
        }
    }

    public static void main(String args[]) throws IOException
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //map 생성
        int mapRow = Integer.parseInt(st.nextToken());
        int mapCol = Integer.parseInt(st.nextToken());
        String[][] map = new String[mapRow][mapCol];
        boolean[][] isVisited = new boolean[mapRow][mapCol];
        for(int i = 0; i < mapRow; i++){
            String tempOneRow = br.readLine();
            for(int j = 0; j < mapCol; j++){
                map[i][j] = String.valueOf(tempOneRow.charAt(j));
            }
        }

        //출발지 선정
        int startRow = 0;
        int startCol = 0;
        boolean flag = true;
        for(int i = 0; i < mapRow; i++){
            for(int j = 0; j < mapCol; j++){
                if(isPossibleStartPoint(map, i, j)){
                    startRow = i;
                    startCol = j;
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        bw.write((startRow + 1) + " " + (startCol + 1) + "\n");

        //선정한 출발지의 앞으로 나아갈 방향 할당
        String direction = "";
        for(int i = 0; i < 4; i++){
            int nextRow = startRow + dRow[i];
            int nextCol = startCol + dCol[i];

            if(nextRow >= 0 && nextCol >= 0 &&
                nextRow < map.length && nextCol < map[0].length &&
                map[nextRow][nextCol].equals("#") && !isVisited[nextRow][nextCol]){
                    direction = dDirection[i];
                }
        }
        
        //지나간 경로 
        dfs(map, isVisited, startRow, startCol, direction);
        bw.write(direction + " \n");
        bw.write(result);

        bw.flush();
        bw.close();
    }
}
