package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16940 {
    static  int n;
    static  List<Integer>[] graph;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());
       arr= new int[n];

         graph=  new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i]= new ArrayList<>();

        }




//연결 리스트 받기
        for(int i=0; i<n-1; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int a= Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);


        }
        StringTokenizer st= new StringTokenizer(br.readLine());
//순서 받음
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(1);


    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        //시작 1번
        queue.add(1);
//조건대로 방문 체크
        boolean[] visited=  new boolean[n+1];
        visited[1] = true;
        int idx =1;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            //연결된 리스트 들을 nextset에 담음
            Set<Integer> nextSet = new HashSet<>();
            //연결 리스트 값들중 방문하지 않은 값들 추가
            for(int next : graph[current]) {
                if(!visited[next]) {
                    nextSet.add(next);
                }
            }
            int size = nextSet.size();
            //idx는 초기에 설정한 현재 탐색중인 값의 순서로 첫번째 부터 시작을 해서 방금
            //넣은 값의 크기들까지 더해 탐색한다는뜻,

            for(int i= idx; i< idx + size; i++) {
                //탐색범위가 n을 초과하거나 nextset에 arr[i]값이 없다면 0출력
                if(i >= n || !nextSet.contains(arr[i]))
                {
                    System.out.println(0);
                    return;
                }
            }

//아니라면 visited처리하고  다시 큐에 추가
        for(int i =idx; i< idx+size; i++) {
            visited[arr[i]]= true;
            queue.add(arr[i]);
        }
//다음 탐색을 위해 값을 증가
        idx += size;

        }
        System.out.println(1);

    }
}
