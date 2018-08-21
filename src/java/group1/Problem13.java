package group1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 解题思路：如果某个罗马数值的后面一位比当前位大，则表示当前位是用做负数相加的，比如IV，其中I后面是V，比I大，则I是用来相减的而不是用来相加的，所以要V-I，
 * 记录出所有需要相减的罗马数字，再将原罗马数字挨个算出总和，再减去两倍需要相减的罗马数字（因为挨个相加的时候加了一遍）
 */

public class Problem13 {

    //每个罗马字母对应的整型数值大小
    public static Map<Character,Integer> map = new HashMap<>();

    //用于比较罗马字母的先后
    public static List<Character> list = new ArrayList<>();

    static{
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        list.add('I');
        list.add('V');
        list.add('X');
        list.add('L');
        list.add('C');
        list.add('D');
        list.add('M');
    }
    public static int romanToInt(String s) {
        if("".equals(s) || s == null)
            return 0;
        int sum = 0;
        char[] chars = s.toCharArray();
        String needDesDouble = "";

        for(int i=0;i<chars.length-1;i++){
            if(list.indexOf(chars[i])<list.indexOf(chars[i+1]))
                needDesDouble = needDesDouble + chars[i];
        }

        sum = convertSingleRomanToInt(s) - 2 * convertSingleRomanToInt(needDesDouble);
        return sum;
    }
    public static int convertSingleRomanToInt(String single){
            int sum = 0;
            char[] chars = single.toCharArray();
            for(char word : chars){
                sum = sum + map.get(word);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
