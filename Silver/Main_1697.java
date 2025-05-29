package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
static  int n,m;
static int[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new int[100001];

        n = Integer.parseInt(st.nextToken());
        m=  Integer.parseInt(st.nextToken());

        System.out.println(bfs(n,m));


    }

    private static int bfs(int n, int m) {
        Queue<Integer>queue= new LinkedList<>();
        visited[n] = 1;
        queue.add(n);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if( current == m) {
                return visited[current] -1;
            }
            for( int next : new int[]{current+1, current-1, current*2}) {
                if (next >= 0 && next <= 100000 && visited[next] ==0) {
                    visited[next] = visited[current] +1;
                    queue.add(next);
                }

            }
        }
        return -1;
    }
}
