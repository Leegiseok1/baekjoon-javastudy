package baekjoon.Gold.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
    static  int l,c;
    static  char[] chars, password;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        chars = new char[c];
        password = new char[l];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<c; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        
        dfs(0,0);
        

    }

    private static void dfs(int start, int depth) {
        if(depth == l) {
            if(isVaild(password)) {
                System.out.println(password);

            }
            return;
        }
        for(int i= start; i<c; i++) {
            password[depth] = chars[i];
            dfs(i +1, depth+1);
        }
    }

    private static boolean isVaild(char[] pwd) {

        int a= 0; int b= 0;

        for( char c :pwd) {
            if( c =='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')  a ++;
            else  b ++;



        }
        return a >=1 && b >=2;
    }
}
