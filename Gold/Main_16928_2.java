package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16928_2 {
    static  int loop, snake;
    static  int[][] loops,snakes;
    static  boolean[] visited;
    static  int[] board;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new int[101];
        visited =new boolean[101];

        loop =Integer.parseInt(st.nextToken());
        snake = Integer.parseInt(st.nextToken());
        loops = new int[loop][2];
        snakes = new int[snake][2];

        for(int i=0; i<loop; i++) {
            st = new StringTokenizer(br.readLine());
            loops[i][0] = Integer.parseInt(st.nextToken());
            loops[i][1] = Integer.parseInt(st.nextToken());

        }
        for(int i=0; i<snake; i++) {
            st = new StringTokenizer(br.readLine());
            snakes[i][0] = Integer.parseInt(st.nextToken());
            snakes[i][1] = Integer.parseInt(st.nextToken());

        }
        bfs();




    }

    private static void bfs() {
        Queue<Integer>queue = new LinkedList<>();
        board[1] =0;
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if(current ==100) {
                System.out.println(board[100]);
                return;
            }

        for(int i=1; i<=6; i++) {
            int x = current + i;



            if( x > 100) continue;
            for (int j = 0; j < loop; j++) {
                if (x == loops[j][0]) {
                    x = loops[j][1];
                    break;
                }
            }

            for (int j = 0; j < snake; j++) {
                if (x == snakes[j][0]) {
                    x = snakes[j][1];
                    break;
                }
            }

            if (!visited[x]) {
                board[x] = board[current] + 1;



                queue.add(x);
                visited[x] = true;
            }

        }
        }
    }
}
