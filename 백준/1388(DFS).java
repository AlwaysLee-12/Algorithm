import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int[][] isVisited;
    static int woodenFlankCount;
    static Stack<Character> stack = new Stack<>();
  
    static void dfs(char[][] floor, int row, int col, int totalRow, int totalCol) {
        if (row == totalRow || col == totalCol || (!stack.isEmpty() && stack.peek() != floor[row][col])) {
            stack.clear();

            return;
        }

        stack.push(floor[row][col]);
        isVisited[row][col] = 1;
        if (floor[row][col] == '-') {
            dfs(floor, row, col + 1, totalRow, totalCol);
        } else if (floor[row][col] == '|') {
            dfs(floor, row + 1, col, totalRow, totalCol);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] floor = new char[row][col];
        isVisited = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            String tempFloor = st.nextToken();
            for (int j = 0; j < col; j++) {
                floor[i][j] = tempFloor.charAt(j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                if (isVisited[i][j] == 0) {
                    dfs(floor, i, j, row, col);
                    woodenFlankCount += 1;
                }
            }
        }

        bw.write(String.valueOf(woodenFlankCount));
        bw.flush();
        bw.close();
    }
}

/***
 * https://www.acmicpc.net/problem/1388
 * 바닥의 세로 크기 N과 가로 크기 M이(N, M <= 50) 주어졌을 때, '-', '|'로 이루어진 바닥 장식 모양을 보고 필요한 나무 판자 개수 구하기
 * '-'이 인접해있고 같은 행에 존재하면 같은 나무 판자로 취급, '|'이 인접해있고, 같은 열에 존재하면 같은 나무판자로 취급
 */

/**
 * 1. 바닥 모양이 담긴 배열 생성(2차원 배열)
 * 2. DFS로 배열 탐색(같은 열이나 행에 존재하면 같은 나무 판자로 취급한다는 조건이니 행이나 열 쭉 깊이 우선 탐색)
 * 3. '-'이나 '|'을 만나면 같은 행이나 열에 인접한 것 중 같은 모양이 있는지 탐색하고 방문 기록 체크(다른 모양이 나올때까지)
 * 4. 탐색하면서 다른 모양이 나오거나 인덱스가 넘어가면 나무 판자 count += 1 후, 다음 진행(2, 3 반복)
 */
