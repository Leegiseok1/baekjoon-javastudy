package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements  Comparable<Edge> {  // 각 다리를 담기 위한 클래스
int from , to,cost; // 출발지 ,도착지 , 다리 개수

public  Edge (int from ,int to , int cost) {
    this.from = from;
    this.to = to;
    this.cost = cost;

}
public  int compareTo(Edge o) {
    return  this.cost - o.cost; //코스트를 저장

}

}


public class Main_17472 {
    static ArrayList<Edge> edges = new ArrayList<>();
    static  int[] parent;
    static  int n,m;
    static  int[][] board;
    static  boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken()); // 배열 크기 입력받기
         m = Integer.parseInt(st.nextToken());
         visited = new boolean[n][m];

         board = new int[n][m];
         for(int i=0; i<n; i++) {  //배열 입력
             st = new StringTokenizer(br.readLine());
             for(int j=0; j<m; j++) {
                 board[i][j] = Integer.parseInt(st.nextToken());

             }

         }
         int count = 2; //섬에 번호를 각자 다르게 붙혀주기

         for(int i=0;i <n; i++) {
             for(int j=0; j<m; j++) {
                 if(board[i][j] ==1  && !visited[i][j])
                     Island(i,j,count++);


             }
         }
         //바다가 아니라면 다리 이어주기
         for(int i=0; i<n; i++) {
             for(int j=0; j<m; j++) {
                 if(board[i][j] != 0  ) {
                     brige1(i,j);
                     brige2(i,j);

                 }

             }
         }

        parent = new int[count ];
        Collections.sort(edges); // 값이 작은 순서대로 정렬
         initUnionFind(count); // parentr 본인으로 설정
         int result = 0;
         int brigeCount =0;
         for( Edge e: edges) { // 부모가 다르다면 부모를 바꾸고 값을추가
             if(find(e.from) != find(e.to)) {
                 union(e.from, e.to);
                 result+= e.cost;
                 brigeCount++;
             }

         }
         if(brigeCount == count -3) {  // 다리의 개수가 섬 개수 -1이 맞다면 출력 아니면 -1
             System.out.println(result);
         } else {
             System.out.println(-1);
         }


    }
//부모 노드를 본인으로 지정
    static  void initUnionFind(int size) {
        parent = new int[size +2];
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

    } //부모를 찾는 과정
    static int find( int x ) {
        if(parent[x] ==x) return x;
        return  parent[x] = find(parent[x]);

    }
 // 부모 바꾸기
    static  void union (int x, int y) {
        int px = find(x);
        int py = find(y);
        if ( px != py) parent[px] =py;
    }

//위 아래
    private static void brige2(int y, int x) {
        int from = board[y][x];
        for(int d= -1; d<=1; d+=2) {
            int ny = y+d;
            int dist = 0;
            while (ny>=0 && ny <n) {
                if(board[ny][x] == from) break;
                if(board[ny][x] >0) {
                    if(from < board[ny][x]&& from != board[ny][x] && dist>=2) {
                        edges.add(new Edge(from,board[ny][x], dist));
                    }
                    break;

                }
                if(board[ny][x] ==0) dist++;
                ny+=d;

            }

        }
    }
//양옆
    private static void brige1(int y, int x) {
        int from = board[y][x];
       for(int d= -1; d<=1; d+=2) {
           int nx = x+ d;
           int dist = 0;
           while ( nx >=0 && nx <m) {
               if(board[y][nx] == from) break;
               if(board[y][nx] > 0) {
                   if(from < board[y][nx]&& from != board[y][nx] &&dist >= 2) {
                       edges.add(new Edge(from, board[y][nx] ,dist));
                   }
                   break;
               }
               if(board[y][nx] == 0) dist++;
               nx +=d;
           }

       }

    }

    private static void Island(int y, int x, int count) {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] {y,x});
        visited[y][x] = true;
        board[y][x] = count;

        while (!queue.isEmpty()) {
            int[] current =  queue.poll();
            int ny = current[0];
            int nx = current[1];

            for(int i=0; i<4; i++) {
                int cy = ny + dy[i];
                int cx=  nx + dx[i];

                if (cy >= 0 && cy < n && cx >= 0 && cx < m && board[cy][cx] == 1 && !visited[cy][cx]) {
                    board[cy][cx] = count;
                    visited[cy][cx] = true;
                    queue.add(new int[] {cy,cx});

                }

            }



        }

    }

}
