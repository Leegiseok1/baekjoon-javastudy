package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a = Integer.parseInt(br.readLine());

        while (a -- >=1) {
            int b = Integer.parseInt(br.readLine());
            int[] page=  new  int[b];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<b; i++) {

                page[i] = Integer.parseInt(st.nextToken());
            }
            int[] sum = new int[b+1];
            for(int i=0; i<b; i++) {
                sum[i+1] = sum[i] + page[i];

            }

            int[][] dp = new int[b][b];

            for(int len = 1; len<b; len ++) {
                for(int i=0; i<=b-len-1; i++) {
                    int j = i + len;
                    dp[i][j] = Integer.MAX_VALUE;

                    for( int k=i; k<j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] +dp[k+1][j] +sum[j+1] - sum[i]);
                    }
                }

            }
            System.out.println(dp[0][b-1]);




        }

    }

}
