package baekjoon.Silver.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
    static  int n,max;
    static  int[][] city;
    static  int[] dy = {1,0,-1,0};
    static  int[] dx = {0,1,0,-1};
    static  boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = 0;
        int count =0;

        city = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max , city[i][j]);

            }
        }
        for(int c= 0; c<max; c++) {
           int  stack = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j] && city[i][j] > c ) {

                        bfs(i,j,c);
                        stack ++;

                    }




                }
            }

            for(int i=0; i<n; i++ ) {
                for(int j=0; j<n; j++) {
                    visited[i][j] = false;
                }
            }
            count = Math.max(count ,stack);
        }

        System.out.println(count);


    }

    private static void bfs(int y, int x, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[] {y,x});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();;
            int ny = current[0];
            int nx = current[1];

            for(int i=0; i<4; i++) {
                int cy = ny+dy[i];
                int cx = nx + dx[i];

                if(cy>=0 && cx>=0 && cy < n&& cx <n && city[cy][cx] > c&& !visited[cy][cx]) {
                    visited[cy][cx] = true;
                    queue.add(new int[] {cy,cx});

                }


            }
        }

    }
}
