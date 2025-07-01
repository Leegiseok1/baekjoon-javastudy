package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14466 {
    static  int n,k,r,a,b,c,d;

    static  boolean[][][][] visited;
    static  int[][] board,cow;



    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
      cow = new int[k][2];
        visited = new boolean[n+1][n+1][n+1][n+1];
        for(int i=0; i<r; i++) {
             st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            visited[a][b][c][d] = true;
            visited[c][d][a][b] = true;
        }
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());

        }

        int sum =0;
        for(int i=0; i<k; i++) {
          sum +=   bfs(cow[i][0] , cow[i][1],i);



        }
        System.out.println(sum);


    }

    private static int bfs(int y, int x, int j) {
        boolean[][] visited1= new boolean[n+1][n+1];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visited1[y][x] =true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
           int ny = current[0];
           int nx =  current[1];

           for(int i=0; i<4; i++) {
               int cy = ny +dy[i];
               int cx = nx + dx[i];
               if(cy <=n && cx <=n &&cy >=1 &&cx >=1) {


             if(!visited[ny][nx][cy][cx]  && !visited1[cy][cx]) {

                 visited1[cy][cx] = true;
                 queue.add(new int[] {cy,cx});


             }
             }


           }




        }
        int count =0;
        for( int i = j+1; i<k; i++) {
            int targetx = cow[i][1];
            int targety =cow[i][0];
            if( targety==y && targetx ==x) continue;
            if(!visited1[targety][targetx]) {
                count ++;

            }


        }
        return count;
    }
}
