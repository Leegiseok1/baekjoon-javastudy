package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234 {
    static  int a,n,m;
    static   int[][] map;
    static  boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        a=  Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[a][a];


        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<a; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int day =0;

        while (true) {

            visited = new boolean[a][a];
            boolean moved = false;

            for(int i=0; i<a; i++) {
                for(int j=0; j<a; j++) {
                    if(!visited[i][j]) {
                List<int[]> union = bfs(i,j);
                if(union.size() >1) {
                    moved = true;
                    int sum = 0;
                    for(int[] pos : union) {
                        sum += map[pos[0]][pos[1]];
                    }
                    int avg = sum / union.size();
                    for(int[] pos : union) {
                        map[pos[0]][pos[1]] = avg;
                    }
                }

                    }
                }
            }
            if(!moved) break;
            day ++;

        }
        System.out.println(day);


    }

    private static List<int[]> bfs(int x, int y) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> queue= new LinkedList<>();
        int[] nx = new int[]{-1,1,0,0};
        int[] ny = new int[] {0,0,-1,1};

        queue.add(new int[]{x,y});
        union.add(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int max = 0;
            int min = 0;
        int[] current = queue.poll();;
        int cx = current[0];
        int cy =current[1];

        for(int i=0; i<4; i++) {
            int ax = cx +nx[i];
            int ay = cy+ny[i];

            if( ax >=0 && ay >= 0 && ax < a && ay < a&& !visited[ax][ay]) {

                max  = Math.max(map[cx][cy],map[ax][ay]);
                min = Math.min(map[cx][cy], map[ax][ay]);

                if ( n <=max - min&& max - min<= m) {
                    queue.add(new int[] {ax,ay});
                    union.add(new int[] {ax,ay});
                    visited[ax][ay] = true;



                }


            }
        }




        }

        return union;
    }
}
