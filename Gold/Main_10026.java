package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    static  int colorcount = 0;
    static  int blindcount= 0;
    static  int[] dx = {0,0,-1,1};
    static  int[] dy = {1,-1,0,0};
    static  int n;
    static  char[][] nomalmap, colorblind;
    static  boolean[][] blind, color;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));

        n=  Integer.parseInt(br.readLine());

        nomalmap = new char[n][n];
        colorblind = new char[n][n];
        blind = new boolean[n][n];
        color = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                nomalmap[i][j] = line.charAt(j);
               colorblind[i][j] = (line.charAt(j) == 'G') ? 'R' : line.charAt(j);


            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!color[i][j]) {
                    bfs(i,j,color,nomalmap);
                    colorcount ++;


                }
                if(!blind[i][j]) {
                    bfs(i,j,blind,colorblind);
                    blindcount++;

                }


            }


        }
        System.out.println(colorcount + " "+blindcount);





    }

    private static void bfs(int y, int x, boolean[][] color, char[][] nomalmap) {
        Queue<int[]> queue = new LinkedList<>();
        color[y][x] = true;

        queue.add(new int[] {y,x});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx=  current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !color[ny][nx] &&
                        nomalmap[cy][cx] == nomalmap[ny][nx]) {


                    color[ny][nx] = true;
                    queue.add(new int[] {ny,nx});


                }


            }
        }

    }
}
