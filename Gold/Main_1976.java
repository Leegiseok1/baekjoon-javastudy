package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976 {
    static int[] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        parent = new int[n+1];
        int[][] trip = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
        int count = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                trip[i][j] = Integer.parseInt(st.nextToken());
                if(trip[i][j] ==1) {
                    union(i,j);
                }



            }


        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] plan = new int[count];
        for(int i=0; i<count; i++) {

            plan[i] = Integer.parseInt(st.nextToken());

        }
        int root = find(plan[0]);

        for(int i=1; i<count; i++) {
            if(find(plan[i]) != root) {
                System.out.println("NO");

                return;

            }
        }
        System.out.println("YES");
    }

    private static void union(int i, int j) {
        int rootA = find(i);
        int rootB = find(j);

        if(rootA != rootB) {
            parent[rootB] =rootA;
        }

    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return  parent[x] = find(parent[x]);
    }
}
