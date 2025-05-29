package baekjoon;
import java.util.*;
public class Main_2869 {
    public static void main(String[] args) {
        Scanner sc =new  Scanner(System.in);
        int count =0;
        int a=sc.nextInt();
        int b=sc.nextInt();
        int v=sc.nextInt();
        int total =1;

        while (count <=v) {

            if(count >=v) {
                break;
            }
            if(count <v) {
                count -=b;
                total++;
            }


        }
        System.out.println(total);





    }

}