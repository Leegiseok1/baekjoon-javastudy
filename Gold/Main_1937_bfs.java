package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1937_bfs {
    static  int[] cx = {1,-1,0,0};
    static  int[] cy = {0,0,-1,1};
    static  int n;
    static  int[][] tree,dp;
    static  int sum=0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n  =Integer.parseInt(br.readLine());
         tree = new int[n][n];
         dp = new int[n][n];
        StringTokenizer st;
         for(int i=0; i<n; i++) {
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<n; j++) {
                 tree[i][j] = Integer.parseInt(st.nextToken());

             }
             
         } for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = 1;

                }
            }



        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( dp[i][j] ==1) {
                    bfs(i,j);
                }
            }
        }
        System.out.println(sum);
        
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();;
            int nx = current[0];
            int ny = current[1];

            for(int i=0; i<4; i++) {
                int dx=  nx + cx[i];
                int dy = ny + cy[i];

                if( dx >= 0 && dy>=0 &&  dx < n &&dy <n &&tree[nx][ny] < tree[dx][dy] ) {
                   if( dp[dx][dy] < dp[nx][ny] +1) {
                       dp[dx][dy] = dp[nx][ny] +1;
                       queue.add(new int[] { dx,dy});
                       sum = Math.max(sum , dp[dx][dy]);
                   }

                }
            }
        }
    }
}
