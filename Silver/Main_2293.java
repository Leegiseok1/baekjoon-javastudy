package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293 {
    static  int n,m;
    static  int[] coins,dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[m+1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int i=coin; i<=m; i++) {
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(dp[m]);



    }
}
