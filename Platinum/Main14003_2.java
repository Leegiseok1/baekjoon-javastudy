package baekjoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14003_2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        int[] pre = new int[n];
        int[] idx = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> lis = new ArrayList<>();
        ArrayList<Integer>lisIdx=  new ArrayList<>();
        for(int i=0; i<n; i++) {
            int cur=  arr[i];
            int pos = reverse(lis, cur);

            if( pos == lis.size()) {
                lis.add(cur);
                lisIdx.add(i);
            } else {
                lis.set(pos, cur);
                lisIdx.set(pos, i);
            }

           idx[i] = pos;

            pre[i] = (pos ==0) ? -1 : lisIdx.get(pos -1);






        }
        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append(" \n");
        int target = -1;

        for(int i =n-1; i>=0; i--) {
            if(idx[i] == lis.size()-1) {
                target = i;
            }

        }
        ArrayList<Integer>result= new ArrayList<>();

        while (target != -1) {
            result.add(arr[target]);
            target = pre[target];
        }

        for(int i = result.size()-1; i>=0; i--) {
            sb.append(result.get(i)).append(" ");

        }
        System.out.println(sb);
    }

    private static int reverse(List<Integer> lis, int cur) {
        int left=  0;
        int right = lis.size();

        while (left < right) {
            int mid = (left +right) /2;

            if( lis.get(mid) >= cur)  {
                right= mid ;
            } else {
                left = mid +1;
            }
        }

        return  left ;
        }



    }

