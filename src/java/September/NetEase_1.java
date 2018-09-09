package September;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 网易0908-1：橡皮泥斑马，给定字符串，只有字符b或者字符w，可以进行任意次在任意位置的字符串截断并且两头反转再拼接，请问最多的相邻不相同的字符串字串的长度有多大
 *
 *      在字符串s上拼接上一个相同字符串s，然后求最大相邻不相同字串。如果比原数组长，那就除2，不然就输出
 *
 *      这题是真没见过，反正没做出来。
 */
public class NetEase_1 {
    public static void main(String[] args) {

        String s = "";
        s += s;
        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            while (i != s.length() - 1 && s.charAt(i) != s.charAt(i+1)) {
                i++;
                j++;
            }
            ans = Math.max(ans, j);
        }
        if (s.length() / 2 < ans) {
            ans = s.length() / 2;
        }
        System.out.println(ans);

    }
}
