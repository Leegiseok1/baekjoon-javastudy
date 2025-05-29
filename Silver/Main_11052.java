package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {
    public static void main(String[] args)throws IOException  {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int a= Integer.parseInt(br.readLine());
    int[] price = new int[a+1];
    int[] dp = new int[a+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=a; i++) {

            price[i] = Integer.parseInt(st.nextToken());
            dp[i]=price[i];
        }

        for( int i=2; i<=a; i++) {
            for(int j=1; j<i; j++) {
                dp[i] =  Math.max(dp[i], dp[i-j] + price[j]);
            }
        }
        System.out.println(dp[a]);
    }
}
