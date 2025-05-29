package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
    static  int n,m;
    static  boolean[] visited= new boolean[26];
    static  int[] dx = {-1,1,0,0};
    static  int[] dy = {0,0,-1,1};
    static  char[][] board;
    static  int max =0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        dfs(0,0,1);
        System.out.println(max);


    }

    private static void dfs(int x, int y, int count) {
    max = Math.max(count,max);
    visited[board[x][y] -'A'] = true;

    for(int i=0; i<4;i ++) {
        int nx = x +dx[i];
        int ny = y +dy[i];

        if(nx >= 0 && ny >=0 && nx <n && ny <m) {
            char nextboard = board[nx][ny];
            if(!visited[nextboard -'A']) {
                dfs(nx,ny,count+1);
            }

        }

    }
    visited[board[x][y]-'A'] = false;

    }


}
