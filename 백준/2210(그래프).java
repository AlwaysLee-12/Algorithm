import java.io.*;
import java.util.*;

public class Main {
    static HashSet<String> set = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int[][] board, int x, int y, String tempCom) {
        if (tempCom.length() == 6) {
            set.add(tempCom);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
                dfs(board, nextX, nextY, tempCom + String.valueOf(board[nextX][nextY]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(board, i, j, String.valueOf(board[i][j]));
            }
        }

        bw.write(String.valueOf(set.size()));

        bw.flush();
        bw.close();
    }
}

/***
 * https://www.acmicpc.net/problem/2210
 * 5x5 숫자판에서 나올 수 있는 서로 다른 6자리 조합의 수
 */

/**
 * 1. 숫자판 생성(이차원 배열)
 * 2. 재귀로 각 노드에서 만들 수 있는 6자리 조합의 수 수집 6자리 조합의 수 수집(중복 X)
 */
