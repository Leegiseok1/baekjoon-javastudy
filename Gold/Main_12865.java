package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    static  int a,b;
    static  int[] dp;
    static int[][] bag;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a=  Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        dp = new int[b+1];

        bag = new int[a][2];

        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());


        }

        for(int i=0; i<a; i++) {
            int weight = bag[i][0];
            int value = bag[i][1];

            for(int j=b; j>=weight; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight] + value);

            }

        }
        System.out.println(dp[b]);



    }
}
