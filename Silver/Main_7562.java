package baekjoon.Silver;
import java.io.*;
import java.util.*;

public class Main_7562 {
    static int[] cx = {1, 2, 2, 1, -1, -2, -1, -2};
    static int[] cy = {-2, -1, 1, 2, 2, 1, -2, -1};
    static int[][] board;
    static boolean[][] visited;
    static int count, n, m, x, y, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            r = Integer.parseInt(br.readLine());
            board = new int[r][r];
            visited = new boolean[r][r];
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int result = bfs(n, m, x, y);
            sb.append(result).append("\n");


        }
        System.out.print(sb);

    }

    private static int bfs(int n, int m, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        // Arrays.fill(board, Integer.MAX_VALUE);
        board[n][m] = 0;
        queue.add(new int[]{n, m});
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int nx = current[0];
            int ny = current[1];

            if (nx == x && ny == y) {


                return board[nx][ny];

            }

            for (int i = 0; i < 8; i++) {
                int dx = nx + cx[i];
                int dy = ny + cy[i];


                if (dx >= 0 && dy >= 0 && dx < r && dy < r && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                    board[dx][dy] = board[nx][ny] + 1;

                }
            }

        }
        return 0;

    }
}

