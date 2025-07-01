package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_2 {
    static int n, a, b;
    static char[][] building;
    static boolean[] key;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]>[] doorList = new LinkedList[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (n > 0) {
            queue = new LinkedList<>();
            doorList = new LinkedList[26];

            for (int i = 0; i < 26; i++) {

                doorList[i] = new LinkedList<>();
            }


            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            key = new boolean[26];
            building = new char[a][b];

            for (int i = 0; i < a; i++) {
                String line = br.readLine();
                for (int j = 0; j < b; j++) {
                    building[i][j] = line.charAt(j);

                }

            }

            String keys = br.readLine();

            if (!keys.equals("0")) {
                for (char k : keys.toCharArray()) {
                    key[k - 'a'] = true;

                }

            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (building[i][j] != '#') {
                        if (i == 0 || j == 0 || i == a - 1 || j == b - 1) {
                            char ch = building[i][j];

                            if (Character.isUpperCase(ch)) {
                                if (!key[ch - 'A']) {
                                    doorList[ch - 'A'].add(new int[]{i, j});
                                    continue;
                                }
                            }
                            queue.add(new int[]{i, j});

                        }
                    }
                }
            }
            for(int K=0; K<26; K++) {
                if(key[K]) {
                    while (!doorList[K].isEmpty()) {
                        queue.add(doorList[K].poll());

                    }
                }
            }


            long result = start();
            System.out.println(result);


            n--;
        }
    }

    private static long start() {
        long count = 0;

        int[] cx = {0, 1, 0, -1};
        int[] cy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[a][b];



        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int nx = current[1];
            int ny = current[0];

            visited[ny][nx] = true;


            for (int i = 0; i < 4; i++) {
                int dy = ny + cy[i];
                int dx = nx + cx[i];
                if (dy < 0 || dy >= a || dx < 0 || dx >= b || visited[dy][dx] || building[dy][dx] == '*') continue;



                char ch = building[dy][dx];


                if (ch == '$') {
                    count++;
                    building[dy][dx] = '.';

                }
                if (Character.isLowerCase(ch) ) {
                    int k = ch - 'a';
                    if (!key[k]) {
                        key[k] = true;
                        building[dy][dx] = '.';
                        while (!doorList[k].isEmpty()) {
                         queue.add(doorList[k].poll());


                        }
                    }
                }
                if (Character.isUpperCase(ch)) {
                    int k = ch - 'A';
                    if (!key[k]) {
                        doorList[k].add(new int[]{dy, dx});
                        continue; // 열쇠 없으면 이동 안 함
                    }
                }
                queue.add(new int[]{dy, dx});

            }

        }


        return count;
    }

}
