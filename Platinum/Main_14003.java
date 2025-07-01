package baekjoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14003 {
    static  int n;

    public static void main(String[] args)throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));


         n  = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] idx = new int[n];
        int[] pre = new int[n];

        //값 입력
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        ArrayList<Integer> lisIdx = new ArrayList<>();
        for(int i=0; i<n; i++) {
            //이건 넣은 값
            int cur = arr[i];

            //값 위치를 이분 탐색으로 찾음
            int pos = lowerBound(lis, cur);

            //새로운 값 추가라면 그대로 추가

            if(pos == lis.size()) {
                lis.add(cur);
                lisIdx.add(i);
            }

            //새로운 값 추가가 아니라면 갱신 이므로 위치와 함께 다시 재지정
            else {
                lis.set(pos, cur);
                lisIdx.set( pos, i);
            }
//idx = 위치 ex) 1번쨰 ,2번쨰 ..
            idx[i] = pos;
            //값이 없다면 -1 혹은 첫번째 수보다 작다면 -1이 나옴
            pre[i]= (pos ==0) ? -1: lisIdx.get(pos -1);

        }

        StringBuilder sb=  new StringBuilder();
        sb.append(lis.size()).append("\n");

        int target= -1;
        //타겟을 길이 크기로 맞춤 0부터 시작 하기대문에  -1을 하여도 됨

        for(int i=n-1; i>=0; i--) {
            if(idx[i] == lis.size() -1) {
                target=i;
                break;
            }

        }
        ArrayList<Integer>result = new ArrayList<>();

        //수열의 길이가 1이 아니라면 마지막 번호부터 값을 넣기 시작
        //아까 -1로 시작을 하였기떄문에 다들 값이 하나씩 밀려 있어서 tarpget으로 계속 넣으면
        //끝까지 들어감

        while (target != -1) {
            result.add(arr[target]);
            target = pre[target];

        }
        //다시 반대로 해서 출력해냄

        for(int i=result.size()-1;  i>=0; i--) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);

    }

    private static int lowerBound(ArrayList<Integer> lis, int key) {
        int left= 0  , right = lis.size();

        while(left< right) {
            int mid =(left+right)/2;
            if(lis.get(mid)>= key) {
                right = mid;

            } else  {
                left = mid +1;
            }

        }
        return left;

    }
}
