package group1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2的31次方) 。
 *
 *
 *
 * 解答：
 *      步骤1：去除空格
 *
 *      步骤2：判定取的第一个字符是数字，还是正负号，还是其他
 *
 *      步骤3：判定后面是否是数字并且是的话是否是零，是零则继续，不是零则获得数字的起点
 *
 *      步骤4：正负号外，开头是非零数字的话，一直获取到第10位（因为Integer最大在十进制中是10位数）都是整数的话，如果下一位还是整数，停止获取，
 *      并且根据最大值给出INT_MAX或者INT_MIN
 *
 *      步骤5：如果小于10位，直接结合正负号输出，如果等于10位，那么用来与INT_MAX与INT_MIN根据正负号对应比大小
 *
 *
 */
public class Problem8 {
    public static int myAtoi(String str) {
        if(str.trim().length() == 0)
            return 0;
        char[] chars = str.trim().toCharArray();
        //下一个如果是0的话是不是需要忽略（用于判断是否是0开头，若前面有非零数字，那么就不能忽略）
        boolean zeroNotIgnore = false;
        //正负flag
        boolean lessThanZero = false;
        List<Character> list = new ArrayList<>();

        //步骤2
        if(chars[0] == '0' || chars[0] == '+'){
        }
        else if(chars[0] == '-'){
            lessThanZero = true;
        }
        else if(Character.isDigit(chars[0])){
            zeroNotIgnore = true;
            list.add(chars[0]);
        } else {
            return 0;
        }




        //步骤3
        char temp;
        for(int i=1;i<chars.length;i++){
            if(!Character.isDigit(chars[i])){
                break;
            }
            temp = chars[i];
            if(!zeroNotIgnore && temp == '0')
                continue;
            list.add(temp);
            if(!zeroNotIgnore)
                zeroNotIgnore = true;




            //步骤4
            if(list.size()>10)
                break;
        }

        if(list.size() == 0)
            return 0;
        if(list.size()>10){
            if(lessThanZero)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        StringBuilder sb = new StringBuilder();
        if(lessThanZero){
            sb.append("-");
        }
        for(char num : list){
            sb.append(num);
        }
        if(list.size()<10){
            return Integer.valueOf(sb.toString());
        }



        //步骤5
        String maxStr = "" + Integer.MAX_VALUE;
        char[] maxChars = maxStr.toCharArray();
        List<Character> maxList = new ArrayList<>();
        for(char s : maxChars){
            maxList.add(s);
        }
        if(lessThanZero){
            maxList.add(maxList.size()-1,(char)(maxList.remove(maxList.size()-1)+1));
        }
        int index = 0;
        int maxIndex = 0;
        while(index < maxList.size()){
            char curr = list.get(index);
            char maxCurr = maxList.get(maxIndex);
            if(curr < maxCurr)
                return Integer.valueOf(sb.toString());
            else if(curr > maxCurr){
                if(lessThanZero)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            else{
                index++;
                maxIndex++;
                continue;
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-2147483649"));
    }
}
