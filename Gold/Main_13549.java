package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_13549 {
    static  int a,b;

    static  int[] location;

    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        location = new int[100001];
        a = Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());


        Arrays.fill(location, Integer.MAX_VALUE);
        location[a] =0;
        bfs(a,b);



    }

    private static void bfs(int a, int b) {
        Deque<Integer> deque= new LinkedList<>();
        deque.add(a);


        while (!deque.isEmpty()) {
            int current= deque.pollFirst();

            if( current == b) {
                System.out.println(location[current]);
                return;
            }
            int next = current*2;
            if(next >= 0 && next <=100000 &&location[next] > location[current]) {
                location[next] = location[current] + 0;
                deque.offerFirst(next);


            }
             next =current+1;
            if(next >= 0 && next <=100000 &&location[next] > location[current] +1) {
                location[next] = location[current] +1;
                deque.offerLast(next);

            }

            next = current-1;
            if(next >= 0 && next <=100000 &&location[next] >location[current] +1) {
                location[next] = location[current] + 1;
                deque.offerLast(next);

            }

            }

        }

        }