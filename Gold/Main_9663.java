package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 {
    static  int n,count;
    static  int[][] board;
    static  boolean[][] visited;
    static  boolean[] colUsed, dia1Used, dia2sed;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        colUsed = new boolean[n];
        dia1Used = new boolean[2*n -1];
        dia2sed = new boolean[2*n-1];

       dfs(0);
       System.out.println(count);




    }

    private static void dfs(int row) {
        if(row == n) {
            count ++;
            return ;
        }
        for(int col = 0; col <n; col++) {
           int d1 = row+col;
           int d2 = row -col + (n-1);
           if(colUsed[col] || dia1Used[d1] || dia2sed[d2])  continue;
               colUsed[col] = true;
               dia2sed[d2] = true;
               dia1Used[d1] = true;

               dfs(row + 1);
             colUsed[col] = false;
             dia2sed[d2] = false;
             dia1Used[d1] = false;

            }

        }
    }

