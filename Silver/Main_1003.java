package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003 {
    static int n,m;
    static int[][]  count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
count = new int[41][2];
       count[0][0] = 1;
       count[0][1] = 0;
       count[1][0] = 0;
       count[1][1] = 1;

        for (int i = 2; i <=40; i++) {
           count[i][0] = count[i-1][0] + count[i-2][0];
           count[i][1] = count[i-1][1] + count[i-2][1];



        }
        for(int i=0; i<n; i++) {
            int a= Integer.parseInt(br.readLine());
            System.out.println(count[a][0] + " " + count[a][1]);
        }




    }


    }



