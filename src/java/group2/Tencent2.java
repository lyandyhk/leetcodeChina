package group2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 *
 *
 * 输入描述:
 * 输入包括两行。
 * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 *
 *
 * 输出描述:
 * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 *
 * 输入例子1:
 * 3
 * 2 7 4
 *
 * 输出例子1:
 * 5
 */
public class Tencent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(getResult(nums));
    }
    public static int getResult(int[] nums){
        int sum = 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[1] - nums[0];

        if(nums.length % 2 == 0){
            for(int i=1;i<nums.length;i = i+2){
                sum = sum + nums[i] - nums[i-1];
            }
        }else{
            for(int i=0;i<nums.length-1;i = i+2){
                sum = sum + nums[i] - nums[i+1];
            }
            sum = sum + nums[nums.length - 1];
        }
        return sum;
    }

}
