package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class  Node1 {
    int num;
    int depth;

     Node1(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }

}

public class Main_1039 {


    static  boolean[][] count;
    static  int m;
    static   Queue<Node1> queue = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int n= Integer.parseInt(st.nextToken());

        m  =Integer.parseInt(st.nextToken());
        queue.add(new Node1(n, 0));
         count = new boolean[m+1][1000001];



       int result = bfs();

       System.out.println(result);

    }

    private static int bfs() {
        int max = -1;
        int counting = m;
        char temp = 0;

        while (! queue.isEmpty()) {
            Node1 current= queue.poll();

            if(current.depth ==m) {

                max = Math.max(max, current.num);
                continue;
            }

            char[] arr=  Integer.toString(current.num).toCharArray();

            if(count[current.depth][current.num]) continue;

                count[current.depth][current.num] = true;



            for(int i=0; i<arr.length; i++) {
                for(int j=i+1; j<arr.length; j++) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if (arr[0] == '0') {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        continue;


                    }

                    int nextnum = Integer.parseInt(new String(arr));


                    queue.add(new Node1(nextnum, current.depth + 1));

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
                }

            }


        return max;

        }





    }


