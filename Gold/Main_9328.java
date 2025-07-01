package baekjoon.Gold;
import java.io.*;
import java.util.*;

public class Main_9328 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] key;
    static Queue<int[]> queue;
    static Queue<int[]>[] doors;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            key = new boolean[26];
            queue = new LinkedList<>();
            doors = new LinkedList[26];
            for (int i = 0; i < 26; i++) doors[i] = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (char c : keyInput.toCharArray()) {
                    key[c - 'a'] = true;
                }
            }

            // 가장자리에 접근 가능한 위치 찾기
            for (int i = 0; i < h; i++) {
                checkEntrance(i, 0);
                checkEntrance(i, w - 1);
            }
            for (int j = 0; j < w; j++) {
                checkEntrance(0, j);
                checkEntrance(h - 1, j);
            }

            int result = bfs();
            System.out.println(result);
        }
    }

    static void checkEntrance(int x, int y) {
        if (map[x][y] == '*') return;
        if (visited[x][y]) return;
        char ch = map[x][y];
        visited[x][y] = true;

        if (ch == '$') {
            queue.offer(new int[]{x, y});
        } else if (Character.isLowerCase(ch)) {
            key[ch - 'a'] = true;
            queue.offer(new int[]{x, y});
        } else if (Character.isUpperCase(ch)) {
            if (key[ch - 'A']) {
                queue.offer(new int[]{x, y});
            } else {
                doors[ch - 'A'].offer(new int[]{x, y});
                return;
            }
        } else {
            queue.offer(new int[]{x, y});
        }
    }

    static int bfs() {
        int docs = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            char ch = map[x][y];
            if (ch == '$') {
                docs++;
                map[x][y] = '.';
            } else if (Character.isLowerCase(ch)) {
                int idx = ch - 'a';
                if (!key[idx]) {
                    key[idx] = true;
                    while (!doors[idx].isEmpty()) {
                        int[] d = doors[idx].poll();
                        queue.offer(d);
                        visited[d[0]][d[1]] = true;
                    }
                }
                map[x][y] = '.';
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visited[nx][ny] || map[nx][ny] == '*') continue;

                char next = map[nx][ny];
                visited[nx][ny] = true;

                if (Character.isUpperCase(next)) {
                    if (key[next - 'A']) {
                        queue.offer(new int[]{nx, ny});
                    } else {
                        doors[next - 'A'].offer(new int[]{nx, ny});
                    }
                } else if (Character.isLowerCase(next)) {
                    queue.offer(new int[]{nx, ny});
                } else {
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return docs;
    }
}
