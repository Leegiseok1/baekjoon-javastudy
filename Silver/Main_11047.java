package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047 {
    public static void main(String[] args)throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int[] coin  = new int[a];

        for( int i=0; i<a; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int sum =0;
int temp;
        for(int i=0; i<a/2; i++) {
         temp = coin[i];
         coin[i] = coin[a-1-i];
         coin[a-1-i] = temp;

        }

        for(int i=0; i<a; i++) {
            sum += b/coin[i];
            b = b%coin[i];
        }

        System.out.println(sum);

    }
}
