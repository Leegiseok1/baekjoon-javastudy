package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10282 {
    static  int[] dist;
    static  int n,d,c,q,w,e;

    static ArrayList<int[]>[]  grpah;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a=  Integer.parseInt(br.readLine());

    for(int i=0; i<a; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         d = Integer.parseInt(st.nextToken());
         c =Integer.parseInt(st.nextToken());
         grpah = new ArrayList[n+1];

         for(int j=0; j<=n; j++) {
             grpah[j] = new ArrayList<>();
         }

         for(int l =0; l<d; l++) {
             st = new StringTokenizer(br.readLine());
             q = Integer.parseInt(st.nextToken());
             w = Integer.parseInt(st.nextToken());
             e = Integer.parseInt(st.nextToken());
             grpah[w].add(new int[] {q,e});


         }
         hacking(c);
int max= 0;
int count =0;

         for(int f=1; f<=n; f++) {
             if (dist[f] != Integer.MAX_VALUE) {
             count ++;
             max = Math.max(max, dist[f]);

         }
         }

        System.out.println(count + " " + max);





    }

    }

    private static void hacking(int x) {

        PriorityQueue<int[]> queue= new PriorityQueue<>((o1 , o2) -> o1[1]-o2[1]);
   boolean[] visited= new boolean[n];
   queue.add(new int[] {x,0});
  dist = new int [n+1];

        Arrays.fill(dist ,Integer.MAX_VALUE);
        dist[x] = 0;

   while (!queue.isEmpty()) {
       int[] curremt = queue.poll();
       int computer = curremt[0];
       int cost =  curremt[1];

       if(cost > dist[computer]) continue;

       for(int[] next : grpah[computer]) {
           int nextcomputer = next[0];
           int nextcost = next[1];

           if( dist[nextcomputer] > dist[computer] + nextcost) {
               dist[nextcomputer] = dist[computer] + nextcost;

               queue.add(new int[] { nextcomputer,dist[nextcomputer]});
           }


       }


   }


    }
}
