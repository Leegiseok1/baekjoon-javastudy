package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    static  int a,b;
    static int[][] miro;
    static boolean[][] visited;
    static  int[] dx = {1,-1,0,0};
    static  int[] dy = {0,0,-1,1};
    static int cost=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        miro = new int[a][b];
        visited = new boolean[a][b];
        for(int i=0; i<a; i++) {
            String Line = br.readLine();
            for(int j=0; j<b; j++) {
                miro[i][j] = Line.charAt(j) - '0';

            }

        }
        bfs();
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {


            int[] current = queue.poll();
            int x= current[0];
            int y = current[1];

            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y + dy[i];

                if( nx>=0 && nx <a && ny>=0 && ny < b && miro[nx][ny] ==1&& !visited[nx][ny]) {
                    miro[nx][ny] = miro[x][y] +1;
                    queue.add(new int[] {nx,ny});
                    visited[nx][ny] = true;

                }


            }


        }
        System.out.println(miro[a-1][b-1]);


    }
}
