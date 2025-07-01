package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_2146 {

    static  class  Node {
        int x,y,dist;

        Node( int y, int x , int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    static  boolean[][] visited;
    static  int[] cx = { 0,0,-1,1};
    static int[] cy = {1,-1,0,0};
    static  int n;
    static  int[][] board;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());
         board = new int[n][n];
         visited = new boolean[n][n];
        StringTokenizer st ;

         for(int i=0; i<n; i++) {
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<n; j++) {
                 board[i][j] = Integer.parseInt(st.nextToken());

             }
         }
         int num =2;
         for(int i=0;i <n; i++) {
             for(int j=0; j<n; j++) {
                 if (board[i][j]==1 && !visited[i][j]) {
                     checknum (i,j,num);

                     num ++;

                 }

             }
         }
         int maxnum = num;
         int answer = Integer.MAX_VALUE;
       for(int i=2; i<maxnum; i++) {

           answer = Math.min(answer, bfs(i));
    }
       System.out.println(answer);


    }

    private static int bfs(int num ) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] ==num) {

                    for(int d=0; d<4; d++) {
                        int nx = j + cx[d];
                        int ny = i + cy[d];

                        if(ny>=0 && nx >=0 && ny < n&& nx < n && board[ny][nx] ==0 ) {
                            queue.add(new Node(i,j,0));
                            visited[i][j] = true;
                            break;

                        }
                    }


                }

            }
        }


        while (!queue.isEmpty()) {

            Node cur = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = cur.y + cy[i];
                int nx = cur.x + cx[i];

                if(ny <0 || nx <0 || ny >=n || nx>=n ||visited[ny][nx]) continue;

                if(board[ny][nx] !=0 && board[ny][nx] != num ){
                    return cur.dist;
                }

                if(board[ny][nx] ==0) {
                    visited[ny][nx] =true;
                    queue.add(new Node(ny,nx, cur.dist+1));
                }
            }

        }

return Integer.MAX_VALUE;
    }

    private static void checknum(int y, int x, int num) {
        Queue<int[]> queue = new LinkedList<>();
        board[y][x] = num;
        visited[y][x] = true;
        queue.add(new int[]{y,x});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ny = current[0];
            int nx = current[1];

            for(int i=0; i<4; i++) {
                int dy = cy[i] + ny;
                int dx = cx[i] + nx;

                if( dy< n && dx <n && dy>=0 &&dx >=0 &&board[dy][dx] ==1&& !visited[dy][dx])  {
                    board[dy][dx] =num;
                    visited[dy][dx] = true;
                    queue.add(new int[] {dy,dx});

                }


            }

        }


    }


}
