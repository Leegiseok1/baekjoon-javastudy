package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class  Node{
    int to;
    int weight;

    public  Node( int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

}

public class Main_1967 {
    static  int n,a;
    static  int max = 0;
    static  boolean[] visited;
    static ArrayList<Node>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visited= new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight =  Integer.parseInt(st.nextToken());
            graph[parent].add(new Node(child, weight));
            graph[child].add(new Node(parent,weight));

        }
        dfs(1,0);

        visited = new boolean[n+1];
        max=  0;
        dfs(a, 0);

        System.out.println(max);
    }

    private static void dfs(int node, int weight) {
        visited[node] = true;
        if( weight > max) {
            max = weight;
            a= node;
        }

        for( Node next : graph[node]) {
            if(!visited[next.to]) {
                dfs(next.to,  weight + next.weight);
            }
        }

    }
}
