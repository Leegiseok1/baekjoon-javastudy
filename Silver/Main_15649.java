package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {
    static int a,b;
    static boolean[] visited;
    static  int[] result;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         a= Integer.parseInt(st.nextToken());
         b=Integer.parseInt(st.nextToken());
         visited = new boolean[a+1];
         result = new int[b];

         dfs(0);

    }

    private static void dfs(int stack) {

        if( stack == b) {
            for(int i=0; i<b; i++) {
                System.out.print(result[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=a; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[stack] = i;
                dfs(stack +1);
                visited[i] = false;
            }
        }

    }
}

