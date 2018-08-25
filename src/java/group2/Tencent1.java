package group2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 小Q定义了一种数列称为翻转数列:
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 * 输入描述:
 * 输入包括两个整数n和m(2 <= n <= 109, 1 <= m), 并且满足n能被2m整除。
 *
 *
 * 输出描述:
 * 输出一个整数, 表示前n项和。
 */
public class Tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        System.out.println(getResult(n,m));
        System.out.println(getResult(323445962,371));
    }
    public static String getResult(int n,int m){
        if(n == 0)
            return "0";
        int times = n/(2*m);
        BigInteger timesB = new BigInteger("" +times);
        BigInteger mB = new BigInteger("" + m);
        BigInteger result = timesB.multiply(mB).multiply(mB);
        return result.toString();
    }
}
