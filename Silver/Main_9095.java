package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_9095 {
static  int sum,count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a= Integer.parseInt(br.readLine());
        for(int i=0; i<a; i++) {
            int b=  Integer.parseInt(br.readLine());
            count = 0;

            dfs(b,0);
            System.out.println(count);
        }

    }

    private static void dfs(int i,int sum) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);



            if( sum == i) {
                count ++;
return;
            }
            else if ( sum > i) {
                return;
            }
            dfs(i,sum+1);
           dfs(i,sum+2);
            dfs(i,sum+3);




    }
}
