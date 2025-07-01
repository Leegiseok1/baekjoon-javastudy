package baekjoon.Bronze;

import java.util.*;
public class Main_1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        double max = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] / max) * 100;
            sum += arr[i];
        }

        System.out.println(sum / n);
    }
}