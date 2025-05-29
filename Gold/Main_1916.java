package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916  {
    static  int city,start,end,count,a,b,c;
    static ArrayList<int[]>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        city = Integer.parseInt(br.readLine());
        graph = new ArrayList[city+1];
        for(int i=0; i<=city; i++) {
            graph[i] = new ArrayList<>();
        }
        count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
             st = new StringTokenizer(br.readLine());
             a = Integer.parseInt(st.nextToken());
             b= Integer.parseInt(st.nextToken());
             c= Integer.parseInt(st.nextToken());
             graph[a].add(new int[] {b,c});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Dijstra(start, end);


    }

    private static void Dijstra(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int[] dist = new int[city+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(new int[] {start,0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();;
            int now = current[0];
            int cost = current[1];

            if( cost > dist[now]) continue;

            for(int[] next : graph[now]) {
                int nextnow = next[0];
                int nextcost= next[1];

                if(dist[nextnow] > dist[now] + nextcost) {
                    dist[nextnow ]=dist[now] +nextcost;
                    queue.add(new int[] {nextnow,dist[nextnow]});
                }
            }

        }
        System.out.println(dist[end]);
    }
}
