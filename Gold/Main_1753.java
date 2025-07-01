package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
    static  int V,E,u,v,w,start;
    static  ArrayList<int[]>[] graph;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
         graph = new ArrayList[V+1];
         for(int i=0; i<=V;i++) {
             graph[i] = new ArrayList<>();
         }
         for(int i=0; i<E; i++) {
             st = new StringTokenizer(br.readLine());
             u= Integer.parseInt(st.nextToken());
             v =Integer.parseInt(st.nextToken());
             w = Integer.parseInt(st.nextToken());
             graph[u].add(new int[] {v,w});

         }
         Dijkstra(start);








    }

    private static void Dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        int[] dist = new int[V+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(new int[] {start,0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();;
            int now = current[0];
            int cost = current[1];

            if( cost > dist[now]) continue;

            for(int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = next[1];
            if(dist[nextNode] > dist[now] + nextCost) {
                dist[nextNode] = dist[now] + nextCost;
                queue.add(new int[]{nextNode,dist[nextNode]});

            }
            }

        }

        for(int i=1; i<=V; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else System.out.println(dist[i]);
        }


    }
}
