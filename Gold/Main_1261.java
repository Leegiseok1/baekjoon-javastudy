package baekjoon.Gold.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261 {
    static  int n,m,cost;
    static  int[][] miro,dist;
    static boolean[][] visited;
    static  int[] dx= {1,-1,0,0};
    static  int[] dy= {0,0,1,-1};
    static final  int INF = 100001;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());

        n  =Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[m][n];
        dist = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
           String line = br.readLine();
            for(int j=0; j<n; j++) {
                miro[i][j] = line.charAt(j) - '0';
                dist[i][j] =INF;

            }
        }
        dijstra();

    }

    private static void dijstra() {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]- b[2]);
        cost =0;
        dist[0][0] = 0;


        queue.add(new int[] {0,0,0});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int y= current[0];
            int x = current[1];
            cost = current[2];
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(ny <0 || ny>=m || nx<0 || nx>=n)continue;



                int newCost = cost + miro[ny][nx];
                if( dist[ny][nx] > newCost) {
                    dist[ny][nx] = newCost;
                    queue.add(new int[] {ny,nx,newCost});
                }

                }
            if( x == n-1 && y == m-1) {
                System.out.println(cost);
                return;
            }


            }
       // System.out.println(dist[n-1][m-1]);
        }



    }

