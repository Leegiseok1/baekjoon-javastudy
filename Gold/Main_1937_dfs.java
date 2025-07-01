package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_1937_dfs {
    static  int[] dx  = {1,-1,0,0};
    static  int[] dy = {0,0,-1,1};
    static  int n;
    static  int sum;
    static  int[][] tree,dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        n  =Integer.parseInt(br.readLine());
        tree=  new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] ==0) {

                    sum = Math.max(sum , dfs(i,j));
                }

            }
        }
        System.out.println(sum);





    }

    private static int dfs(int x, int y) {
        if( dp[x][y] !=0) return  dp[x][y];

        dp[x][y]= 1;

       for(int i=0; i<4; i++) {
           int nx= x +dx[i];
           int ny = y +dy[i];

           if( nx>=0 && nx < n && ny>=0 && ny <n &&tree[x][y] < tree[nx][ny]) {
               dp[x][y] = Math.max(dp[x][y] , dfs(nx,ny) +1);



               }

           }

       return dp[x][y];


       }




    }

