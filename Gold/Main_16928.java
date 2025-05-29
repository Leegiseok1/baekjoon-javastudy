package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928 {
    static  int n,m,x,y,u,v;
    static  int[][] loop, snake;
    static  int[] location;
    static  boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        loop = new int[n][2];
        snake = new int[m][2];
        location = new int[101];
        visited = new boolean[101];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            loop[i][0]=Integer.parseInt(st.nextToken());
            loop[i][1]=Integer.parseInt(st.nextToken());

        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            snake[i][0]=Integer.parseInt(st.nextToken());
            snake[i][1]=Integer.parseInt(st.nextToken());
        }

        bfs();



    }

    private static void bfs() {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(1);
        visited[1]= true;
        location[1] =0;
        while (!queue.isEmpty()) {


            int current = queue.poll();

            if(current ==100) {
                System.out.println(location[100]);
                return;
            }
            for(int i=1; i<=6; i++) {
                int next = current + i;
                if (next > 100) continue;
                ;


                for (int j = 0; j < n; j++) {
                    if (next == loop[j][0]) {
                        next = loop[j][1];
                        break;
                    }
                }
                for (int j = 0; j < m; j++) {
                    if (next == snake[j][0]) {
                        next = snake[j][1];
                        break;
                    }
                }
                if(!visited[next]) {
                    visited[next] =true;
                    location[next] = location[current] +1;
                    queue.add(next);
                }
            }



        }

    }
}
