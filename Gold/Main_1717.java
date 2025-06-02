package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717 {
    static  int[] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         parent = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int count =Integer.parseInt(st.nextToken());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if( count == 0) {
                union(a,b);
            }
            else if (count ==1) {
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB =find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
        }

    }

    private static int find(int x) {
        if(parent[x] ==x) return  x;
        return parent[x] = find(parent[x]);

    }
}
