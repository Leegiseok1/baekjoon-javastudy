package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17822 {
    static  int n,m,t,x,d,k;
    static  Deque<Integer>[] queue;
    static  boolean same = false;
    static  boolean[][] erase;


 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=  Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());


        queue = new ArrayDeque[n];
       for(int i=0; i<n; i++) {
           queue[i] = new ArrayDeque<>();
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<m; j++) {
               queue[i].addLast(Integer.parseInt(st.nextToken()));
           }
       }


        for(int i=0; i<t; i++) {
            erase = new boolean[n][m];
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k  =Integer.parseInt(st.nextToken());

            for(int j=x; j<=n; j+=x) {
                int idx = j -1;
                if( d == 1 ) {
                    reverse(idx);
                }
                else if ( d ==0) {
                    spin(idx);
                    
                }
                same = false;

                List<int[]> eraseList = new ArrayList<>();
                for(int y=0; y<n; y++) {
                    for(int x=0; x<m; x++) {
                        if(getValue(y,x) !=0 && bfs(y,x)) {
                            same = true;
                        }





                    }

                }
                if(same) {
                    for (int y = 0; y < n; y++) {
                        List<Integer> row = new ArrayList<>(queue[y]);
                        for (int x = 0; x < m; x++) {
                            if (erase[y][x]) {
                                row.set(x, 0);
                            }
                        }
                        queue[y] = new ArrayDeque<>(row);
                    }
                }
                if(!same) {
                    int sum = 0;
                    int count =0;

                    for(int ny=0; ny<n; ny++) {
                        List<Integer> row = new ArrayList<>(queue[ny]);
                        for(int nx=0; nx<m; nx++) {
                            int val = row.get(nx);
                            if(val!=0) {
                                sum+= val;
                                count ++;
                            }

                        }

                    }
                    if(count ==0 ) continue;

                    int avg = sum /count;

                    for(int dy =0; dy<n; dy++) {
                        List<Integer>row = new ArrayList<>(queue[dy]);
                        for (int dx = 0; dx<m; dx++) {
                            int val = row.get(dx);
                            if(val ==0)continue;
                            if(val > avg) row.set(dx, val-1);
                            else  if ( val < avg) row.set(dx,val+1);


                        }
                        queue[dy] = new ArrayDeque<>(row);
                    }


                }


            }

        }
        int num =0;

        for(int i=0; i<n; i++) {

            for(int j=0; j<m; j++) {

                List<Integer>next = new ArrayList<>(queue[i]);
                int target = next.get(j);
                num +=target;

            }
        }
        System.out.println(num);




    }

    private static int getValue(int y, int x)
    {
        List<Integer> row= new ArrayList<>(queue[y]);
        return row.get(x);

    }

    private static boolean bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited=  new boolean[n][m];

       boolean same = false;
       List<int[]> erastList = new ArrayList<>();

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        q.add(new int[] {y,x});
        erastList.add(new int[] {y,x});

        List<Integer> startRow = new ArrayList<>(queue[y]);
        int target = startRow.get(x);
        if (target ==0) return same;

        visited[y][x] = true;



        while (!q.isEmpty()) {

            int[] current = q.poll();
            int ny = current[0];
            int nx = current[1];
        for(int i=0; i<4; i++) {
           int cy = ny + dy[i];
            int cx = (nx + dx[i] + m) % m;

            if(cy <0 || cy >=n ||cx <0 || cx >=m || visited[cy][cx]) continue;

            List<Integer> next = new ArrayList<>(queue[cy]);
            if(next.get(cx) == target) {
                visited[cy][cx] =true;

                q.add(new int[] {cy,cx});
                erastList.add(new int[] {cy,cx});

            }
        }
        }

        if (erastList.size() >= 2) {
            for (int[] pos : erastList) {
                erase[pos[0]][pos[1]] = true;
            }
            return true;
        } else {
            return false;
        }
    }








    private static void spin(int idx) {
        for(int i=0; i<k; i++) {
            queue[idx].addFirst(queue[idx].pollLast());

        }
    }

    private static void reverse(int idx) {
        for(int i=0; i<k; i++) {
            queue[idx].addLast(queue[idx].pollFirst());

        }
    }
}
