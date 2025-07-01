package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_11049 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a= Integer.parseInt(br.readLine());
        int[][] procession = new int[a][2];
        int[][] dp = new int[a][a];

        StringTokenizer st;
        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());
            procession[i][0] = Integer.parseInt(st.nextToken());
            procession[i][1] = Integer.parseInt(st.nextToken());

        }




        for(int len = 2; len<=a; len++) {
            for(int i=0; i<=a - len; i++) {
                int j = i+len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j] ,
                            dp[i][k] + dp[k+1][j] +
                     procession[i][0] * procession[k][1] * procession[j][1]);


                }
            }


        }
        System.out.println(dp[0][a-1]);
        }

    }


