package baekjoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_9376 {
    static  int answer ;

static     class   Node {
        int y,x,cost;
        Node(int y, int x, int cost) {
            this.y = y;
            this.x=x;
            this.cost=cost;
        }

    }
    static  int[][] dist0,dist1,dist2;
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int n  =Integer.parseInt(br.readLine());

        for(int d=0; d<n; d++) {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h =Integer.parseInt(st.nextToken());
        int w=  Integer.parseInt(st.nextToken());
        List<int[]> prisoners = new ArrayList<>();

        answer = Integer.MAX_VALUE;


        char[][] map = new char[h+2][w+2];
        for(int i=1; i<=h; i++) {
            String line = br.readLine();
            for(int j=1; j<=w; j++) {
                map[i][j] = line.charAt(j-1);
                if( map[i][j] =='$' ) {
                    prisoners.add(new int[] {i,j});
                }

            }
        }

        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                if( i ==0||j ==0 || i == h+1 || j == w+1) {
                    map[i][j] = '.';
                }

            }
        }
        dist0 = new int[h+2][w+2];
        dist1 = new int[h+2][w+2];
        dist2 = new int[h+2][w+2];

        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {

                dist0[i][j] = -1;
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }
        bfs(0,0 ,dist0,map);
        bfs(prisoners.get(0)[0],prisoners.get(0)[1] ,dist1,map);
        bfs(prisoners.get(1)[0],prisoners.get(1)[1], dist2 ,map);

        for(int i=0; i<h+2; i++) {
            for(int j=0; j<w+2; j++) {
                if(dist0[i][j] == -1 || dist1[i][j] == -1 || dist2[i][j] == -1) continue;

                int total = dist0[i][j] + dist1[i][j] + dist2[i][j];

                if(map[i][j] == '#') {
                total -= 2;


                }
                answer = Math.min(answer , total);
            }
        }
        System.out.println(answer);
}
    }

    private static void bfs(int y, int x, int[][] dist, char[][] map) {
        int h = map.length;
        int w = map[0].length;

        int [] dy ={-1,1,0,0};
        int [] dx = {0,0,-1,1};

        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(y,x,0));
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            for(int i=0; i<4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if( nx< 0 || ny <0 || ny >=h || nx >=w ) continue;

                if(map[ny][nx] == '*') continue;
                int nextCost = cur.cost;
                if(map[ny][nx] == '#') nextCost +=1;

                if(dist[ny][nx] != -1 && dist[ny][nx] <= nextCost) continue;

                dist[ny][nx] = nextCost;

                if(map[ny][nx] == '#') {
                    dq.addLast(new Node(ny,nx,nextCost));
                } else
                { dq.addFirst(new Node(ny,nx,nextCost));

                    

                }
            }


        }



    }
}
