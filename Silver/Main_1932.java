package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_1932 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a= Integer.parseInt(br.readLine());
        int[][] dp =new int[a][a];
        for(int i=0; i<a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {

            dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=a-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
            dp[i][j] += Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
