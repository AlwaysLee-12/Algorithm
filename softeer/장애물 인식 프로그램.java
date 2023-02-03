import java.util.*;
import java.io.*;


public class Main
{
    static boolean[][] isVisited;
    static List<Integer> obtacles = new ArrayList<>();
    static int obtacleCount = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dfs(int[][] map, int row, int col, int mapSize){
        if(map[row][col] == 0){

            return 0;
        }

        isVisited[row][col] = true;
        obtacleCount += 1;

        for(int i = 0; i < dx.length; i++){
            int nextX = row + dx[i];
            int nextY = col + dy[i];
            if(nextX > -1 && nextY > -1 && nextX < mapSize && nextY < mapSize && !isVisited[nextX][nextY]){
                dfs(map, nextX, nextY, mapSize);
            }
        }
        
        return obtacleCount;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mapSize = Integer.valueOf(br.readLine());
        
        int[][] map = new int[mapSize][mapSize];
        isVisited = new boolean[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++){
            String data = br.readLine();
            for(int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(String.valueOf(data.charAt(j)));
            }
        }

        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                if(map[i][j] > 0 && !isVisited[i][j]){
                    obtacles.add(dfs(map, i, j, mapSize));
                    obtacleCount = 0;
                }
            }
        }

        Collections.sort(obtacles);
        
        bw.write(String.valueOf(obtacles.size()));
        if(obtacles.size() > 0){
            for(Integer num : obtacles){
                bw.write("\n");
                bw.write(String.valueOf(num));
            }
        }

        bw.flush();
        bw.close();
    }
}

/*
 * 이차원 배열이 주어졌을 때 인접한 1들의 모음 개수와 각 모음의 1의 개수 구하기
 * 1. 입력 받은 값들 배열에 넣음
 * 2. 방문을 하지 않은 곳이라면, dfs로 인접한 1들의 묶음 생성
 * 3. dfs
 * 3-1. 현재 노드에 방문 체크
 * 3-2. 1의 개수 ++
 * 3-3. 상하좌우중 다음으로 이동할 노드 확인(인덱스가 오버되지 않으면서 방문하지 않은 곳인지)
 * 3-4. 다음 노드가 0인 것을 만날때까지 위 내용 반복
 * 4. dfs를 해 받은 1의 묶음에서 1의 개수 추출 후 초기화
 * 5. 1의 묶음들 각각의 1의 개수를 담은 리스트 오름차순 
*/
