package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779 {
    static ArrayList<int[]>[] graph;
    static int a, b, c, start, end, city, count;
    static boolean[] visited;
    static int[] dist, prev;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        city = Integer.parseInt(br.readLine());
        count=Integer.parseInt(br.readLine());
        graph = new ArrayList[city+1];
        for(int i=0; i<=city; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;

        for(int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            a= Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            graph[a].add(new int[] {b,c});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());

        Dijkstra(start, end);



    }

    private static void Dijkstra(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        visited =new boolean[ city+1];
        dist = new int[city+1];
        prev =new int[city+1];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        dist[start]=0;
        queue.add(new int[] {start,0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int now = current[0];
            int cost = current[1];
            if(cost > dist[now]) continue;

            for(int[] next : graph[now]) {
                int nextCity = next[0];
                int nextCost = next[1];

                if( dist[nextCity] > dist[now] +nextCost) {
                    dist[nextCity] =dist[now] + nextCost;
                    prev[nextCity] = now;
                    queue.add(new int[] {nextCity, dist[nextCity]});
                }
            }
        }
        System.out.println(dist[end]);
        printPath(end);

    }

    private static void printPath(int end) {
        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        while(cur != -1) {
            path.add(cur);
            cur = prev[cur];
        }
        System.out.println(path.size());
        for(int i= path.size()-1; i>=0; i--) {
            System.out.print(path.get(i)+ " ");
        }
    }
}
