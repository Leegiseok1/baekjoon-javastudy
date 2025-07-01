package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int[] b = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);


        int c = Integer.parseInt(br.readLine());


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < c; i++) {

            int target = Integer.parseInt(st.nextToken());

            if (search(b, target)) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }


        }
    }

    private static boolean search(int[] b, int target) {

        int left = 0;
        int right = b.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (b[mid] == target) {
                return true;
            } else if (b[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;

            }

        }

    return false;
    }
}

