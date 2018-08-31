package group2;

import java.util.Scanner;

/**
 * 头条试题
 *
 * 正确表达式，问n个字符的字符串能有多少种正确的表达式，可以括号，加减号，全0算正确表达式
 * 这些为不正确表达式： -100,(-100),+33,33+
 *
 * 解答：动态规划，两个数组，一个表示纯数字组合，另一个表示有特殊符号的组合
 */

public class Toutiao_2_3 {
    public static void main(String[] args) {
        int dp_1[] = new int[10001];
        int dp_2[] = new int[10001];
        final int mod = 1000000007;
        dp_1[1] = dp_2[1] = 10;
        dp_1[2] = dp_2[2] = 100;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            dp_1[i] = dp_1[i - 1] * 10 % mod;
        }
        for (int i = 2; i <= n; i++) {
            dp_2[i] = (dp_1[i] + dp_2[i - 2]) % mod;
            for (int j = 2; j <= i - 1; j++) {
                dp_2[i] = (dp_2[i] + 2 * (dp_2[j - 1] * dp_2[i - j])) % mod;
            }

        }
        System.out.println(dp_2[n]);
    }
}
