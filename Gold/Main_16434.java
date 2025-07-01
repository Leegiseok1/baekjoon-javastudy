package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main_16434 {
    static  int[][] stage;
    static  int a,b;
    static  int[] player;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         a= Integer.parseInt(st.nextToken());
         b= Integer.parseInt(st.nextToken());
        stage = new int[a][3];
        player = new int[3];
        player[0] = b;

        for(int i=0; i<a; i++) {
        st = new StringTokenizer(br.readLine());
        stage[i][0] = Integer.parseInt(st.nextToken());
        stage[i][1] = Integer.parseInt(st.nextToken());
        stage[i][2] = Integer.parseInt(st.nextToken());

        }

       long result =  function(a);
System.out.println(result);


    }

    private static long function(int x) {
        long left=  1;
        long right = Long.MAX_VALUE;
        long answer = right;


        while (left<=right) {
        long mid = (left+right)/2;
        if(Heart(mid)) {
            answer = mid;
            right=  mid -1;

        } else {
            left = mid +1;
        }




        }

         return answer;
    }

    private static boolean Heart(long mid) {
        long   heart = mid;
        long attck = b;
        for(int i=0; i<a; i++) {
             if( stage[i][0]  ==1 ) {
                 long MonsterHp = stage[i][2];
                 long MosterAttck = stage[i][1];
                 long turn  = (MonsterHp + attck-1)/attck;
                 heart -= MosterAttck * (turn -1);

                 if(heart<= 0) return false;


             }
             if(stage[i][0] == 2) {
                 attck += stage[i][1];
                 if( heart+stage[i][2] <= mid) heart += stage[i][2];
                 else if (heart+stage[i][2] >= mid)
                     heart = mid;



             }


        }
        return  true;
    }
}
