package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9461 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
int a= Integer.parseInt(br.readLine());
        long [] dp = new long[101];

        dp[1] = 1;
        dp[2]=1;
        dp[3]=1;

        for( int j=4; j<101; j++) {
            dp[j] = dp[j - 2] + dp[j - 3];
        }
for(int i=0; i<a; i++) {
    int b = Integer.parseInt(br.readLine());
System.out.println(dp[b]);



        }
    }
}




