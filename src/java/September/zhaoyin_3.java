package September;

import java.util.Scanner;



public class zhaoyin_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i=1;i<=n;i++){
            if(isGoodNum(i))
                count++;
        }
        System.out.println(count);

    }
    public static boolean isGoodNum(int n){
        String num = "" + n;
        if(num.contains("3") || num.contains("4") || num.contains("7"))
            return false;
        if(num.contains("6") || num.contains("9") || num.contains("2") || num.contains("5"))
            return true;
        return false;
    }
}
