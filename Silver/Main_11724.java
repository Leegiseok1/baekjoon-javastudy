package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724 {
static boolean[] visited;
static int count;
static  ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=  Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());


        for(int i=0; i<=a; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[a+1];

        for(int i=0; i<b; i++) {
           st = new StringTokenizer(br.readLine());
            int c= Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(c).add(d);
            graph.get(d).add(c);



        }
        count = 0;
    for(int i=1; i<=a; i++) {

if(!visited[i]) {
            bfs(i);
            count++;
        }
    }
    System.out.println(count);
    }

    private static void bfs(int start) {
         Queue<Integer> queue = new LinkedList<>();
         queue.add(start);
         visited[start] = true;
         while ( !queue.isEmpty()) {
             int current = queue.poll();
             for(int next : graph.get(current)) {
                 if(!visited[next]) {
                     visited[next] =true;
                     queue.offer(next);
                 }
             }

         }
    }
}
