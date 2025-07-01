package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
    static int n;
    static int[] num;
    static int[] math;
    static  int min = Integer.MAX_VALUE;
    static  int max= Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        math = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            math[i] = Integer.parseInt(st.nextToken());

        }

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int depth, int currentResult) {
        if (depth == n) {
            min = Math.min(min, currentResult);
            max = Math.max(max, currentResult);
            return;

        }
        for (int i = 0; i < 4; i++) {
            if (math[i] > 0) {
                math[i]--;
                int nextResult = 0;
                if (i == 0) nextResult = currentResult + num[depth];
                else if (i == 1) nextResult = currentResult - num[depth];
                else if (i == 2) nextResult = currentResult * num[depth];
                else {
                    if (currentResult < 0) {
                        nextResult = -(-currentResult/ num[depth]);
                    } else {
                        nextResult = currentResult / num[depth];
                    }

                }

                dfs(depth + 1, nextResult);
                math[i]++;


            }
        }
    }
}

