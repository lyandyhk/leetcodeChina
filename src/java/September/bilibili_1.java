package September;

/**
 * 2233娘扭蛋机
 */

import java.util.Scanner;

public class bilibili_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curr = n;
        String result = "";
        while(curr>0){
            if(curr % 2 == 0){
                curr = (curr - 2) / 2;
                result = "3" + result;
            }
            else{
                curr = (curr - 1) / 2;
                result = "2" + result;
            }
        }
        System.out.println(result);

    }
}
