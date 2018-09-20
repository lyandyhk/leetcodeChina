package September;

import java.util.Scanner;



public class zhaoyin_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(jump(n));
    }
    public static int jump(int n){
        if(n == 1 || n == 0)
            return 1;
        else
            return jump(n-1) + jump(n-2);
    }
}
