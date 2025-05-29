package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144 {
    static int n, m, t;
    static int[][] map;
    static int[] airCleaner = new int[2];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int airIdx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) airCleaner[airIdx++] = i;
            }
        }

        for (int time = 0; time < t; time++) {
            spread();
            clean();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void spread() {
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == -1) continue;
                        tmp[nx][ny] += amount;
                        cnt++;
                    }
                    tmp[i][j] += map[i][j] - (amount * cnt);
                }
            }
        }

        tmp[airCleaner[0]][0] = tmp[airCleaner[1]][0] = -1;
        map = tmp;
    }

    static void clean() {
        int top = airCleaner[0];
        int bottom = airCleaner[1];

        // top: 반시계
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < m - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][m - 1] = map[i + 1][m - 1];
        for (int i = m - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // bottom: 시계
        for (int i = bottom + 1; i < n - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < m - 1; i++) map[n - 1][i] = map[n - 1][i + 1];
        for (int i = n - 1; i > bottom; i--) map[i][m - 1] = map[i - 1][m - 1];
        for (int i = m - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }
}
