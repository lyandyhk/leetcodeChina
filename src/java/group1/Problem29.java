package group1;

/**
 *
 *给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 *
 *
 *
 *
 * 解答： 当除数和被除数其中出现MIN_INT的时候，都要单独讨论，因为没办法用Integer来表示正向的MIN_INT，解决方法用MAX_INT来表示正向MIN_INT，并且对这样转换的会改变的结果进行处理
 *
 *       整体逻辑就是先用相同位数大小的被除数的前面的位数进行循环相减，得到结果作为商的开头，如果不够用了就往下拿一位，继续循环减，结束条件为被除数无下面一位为止。
 */
public class Problem29 {
    //用来处理除数为十位数的情况
    public static int HALF_INTEGER_MIN_POSITIVE = 1073741824;

    public static int divide(int dividend, int divisor) {

        //如果除数为MIN_INT，那么只有当被除数为MIN_INT的时候结果为1，其余都为0
        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE)
                return 1;
            else
                return 0;
        }
        //用来判断最后结果是正数还是负数的标记，每当除数与被除数二者中出现一个负数时，符号变向
        boolean isPositive = true;

        String dividentStr = "";
        /**
         * 当被除数为MIN_INT的时候，如果除数为1或-1，直接得到答案,对2再做判断的原因是因为MIN_INT无法转换成正向的Integer，
         * 所以把正向的MIN_INT就用MAX_INT来代替，又因为代替之后对结果有影响的情况只有除数为正负2的情况，因为当除数绝对值大于2时，
         * 被除数上少1对整数型商是没有差别的
         */

        //MAX_INT来代替MIN_INT
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1)
                return Integer.MAX_VALUE;
            if(divisor == 1)
                return Integer.MIN_VALUE;
            if(divisor == 2)
                return HALF_INTEGER_MIN_POSITIVE - HALF_INTEGER_MIN_POSITIVE - HALF_INTEGER_MIN_POSITIVE;
            if(divisor == -2)
                return HALF_INTEGER_MIN_POSITIVE;
            if(dividend < 0) {
                isPositive = !isPositive;
            }
            dividend = Integer.MAX_VALUE;
        }
        if(dividend < 0){
            isPositive = !isPositive;
            //因为不能用乘除法，所以改用了两次相减得到相反数
            dividend =  dividend - dividend - dividend;
        }

        if(divisor < 0){
            isPositive = !isPositive;

            divisor =  divisor - divisor - divisor;
        }

        String divisorStr = "" + divisor;
        String result = "";

        dividentStr = "" + dividend;
        if(dividentStr.length() < divisorStr.length())
            return 0;
        //当前被除数上所遍历到的位置，字符串表示形式
        String curr = dividentStr.substring(0,divisorStr.length()-1);
        //商当前位数的值
        int j = 0;
        //上一次结果剩余数的整型表示形式
        int currDividentInt;

        //整体逻辑就是先用相同位数大小的被除数的前面的位数进行循环相减，得到结果作为商的开头，如果不够用了就往下拿一位，继续循环减，结束条件为被除数无下面一位为止。
        for(int i=divisorStr.length()-1;i<dividentStr.length();i++){
            curr = curr + dividentStr.charAt(i);
            currDividentInt = Integer.valueOf(curr);
            while(currDividentInt >= divisor){
                currDividentInt = currDividentInt - divisor;
                j++;
            }
            result = result + j;
            j = 0;
            curr = "" + currDividentInt;
        }
        if(!isPositive)
            return  Integer.valueOf("-" + result);
        return Integer.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE,265681027));
    }
}
