package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main_14502 {
    static  int count = 0;
    static  int start;
    static  List<int[]> blank,viruses;
    static  int[][] map;
    static  int maxSafArea=0;
    static  int SafArea=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

         map = new int[n][m];
        blank = new ArrayList<>();
         viruses = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());


                if(map[i][j] ==0) {
                    blank.add(new int[] {i,j});

                }

                if(map[i][j]==2) {
                    viruses.add(new int[] {i,j});

                }


            }


        }
        makewall(count, start, map);

        System.out.println(maxSafArea);




    }

    private static void makewall(int count, int start, int[][] map) {

        if( count ==3) {
            int[][] Copymap = new int[map.length][map[0].length];
            for(int i=0; i<map.length; i++) {
                Copymap[i] = map[i].clone();
            }
            
            spread(Copymap);
            maxSafArea = Math.max(maxSafArea,SafArea);
            return;
        }



            for (int i = start; i < blank.size(); i++) {
                int[] pos = (int[]) blank.get(i);
                map[pos[0]][pos[1]] = 1;

                makewall(count+1, i+1, map);
                map[pos[0]][pos[1]] = 0;




            }

    }

    private static void spread(int[][] copymap) {
        int n = map.length;
        int m = map[0].length;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};



        Queue<int[]> queue = new LinkedList<>();

        for(int[] v : viruses) {
            queue.add(new int[] {v[0], v[1]});
        }

        while (!queue.isEmpty()) {
            int [] cur = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] +dy[i];

                if( nx< 0 ||ny <0 || nx >=n || ny>=m)  continue;
                if(copymap[nx][ny] ==0) {
                    copymap[nx][ny] =2;
                    queue.add(new int[] {nx,ny});

                }
            }
        }
        SafArea =0;

        checkSafeArea(copymap);


    }

    private static void checkSafeArea(int[][] copymap) {
        int n = map.length;
        int m = map[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(copymap[i][j] == 0) {

                    SafArea++;

                }

            }
        }

    }
}
