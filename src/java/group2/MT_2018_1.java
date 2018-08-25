package group2;

import java.util.Scanner;

public class MT_2018_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMethod(n));
    }
    public static int getMethod(int n){
        if(n == 1 || n == 0)
            return 1;
        int sum = 0;
        for(int i=n-1;i>=0;i--){
            sum = sum + getMethod(i);
        }
        return sum;
    }
}
