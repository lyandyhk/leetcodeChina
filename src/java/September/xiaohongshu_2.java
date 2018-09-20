package September;

import java.util.Scanner;

/**
 *    1! * 2! * 3! * .... * n!末尾一共多少个0，感觉没毛病，0.4，不太懂
 */
public class xiaohongshu_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<5){
            System.out.println(0);
            return;
        }
        int count = 0;
        int curr = 0;
        for(int i=5;i<=n;i++){
            if(i % 5 == 0){
                curr = i / 5;
                curr += timesOfFive(i);
                count += curr;
            }
            else{
                count += curr;
            }
        }
        System.out.println(count);

    }
    public static int timesOfFive(int num){
        int count = 0;
        while(num != 0){
            num = num / 5;
            count++;
        }
        return count - 2;
    }

}
