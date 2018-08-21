package group1;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class Problem14 {
    public static String longestCommonPrefix(String[] strs) {

        //数组为空返回空字符串
        if(strs.length == 0)
            return "";
        //数组长度为1返回该字符串
        if(strs.length == 1)
            return strs[0];
        String minStr = strs[0];
        for(String s : strs){
            if(minStr.length() > s.length())
                minStr = s;
        }
        //数组中如果存在长度为0的字符串，返回""
        if(minStr.length() == 0)
            return "";

        //当前所在字符是否所有字符串在该index都是该值
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<minStr.length();i++){
            char currChar = minStr.charAt(i);
            for(String currStr : strs){
                if(currStr.charAt(i) == currChar)
                    continue;
                else {
                    flag = false;
                    break;
                }
            }
            if(flag)
                sb.append(currChar);
            else
                break;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca","cba"}));
    }
}
