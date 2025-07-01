package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16437 {
    static  List<Integer>[] graph;
    static  boolean[] wolf;
    static  long[] count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int a= Integer.parseInt(br.readLine());
        wolf = new boolean[a+1];
         count = new long[a+1];
      graph = new ArrayList[a+1];

        for(int i=1; i<=a; i++) {
            graph[i] = new ArrayList<>();
        }



        for(int i=2; i<=a; i++) {
            st = new StringTokenizer(br.readLine());
            String b = st.nextToken();
            int c= Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[d].add(i);

            if(b.equals("W")) {
                wolf[i] = true;
                count[i] = c;

            } else {
                count[i] = c;
            }


        }
        long result = dfs(1);
        System.out.println(result);




        }

    private static long dfs(int i) {
        long total = 0;
        for(int child : graph[i]) {
            total+=dfs(child);
        }

        if(wolf[i]) {
            total -= count[i];
            if( total < 0 ) total =0;
        }
        else  total += count[i];
        return total;
    }
}


