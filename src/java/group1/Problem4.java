package group1;

/**
 *
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb
 */
public class Problem4 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int curr = 0;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        String maxSub = "";
        if(s.length() == 1)
            return s;
        while(curr < s.length() -1){
            while(isNextSame(s,curr)){
                curr++;
                right++;
            }
            while(isLROK(s,left,right)){
                left--;
                right++;
            }
            if(right-left+1>maxCount){
                maxSub = s.substring(left,right+1);
                maxCount = right-left+1;
            }
            curr++;
            left = right = curr;
        }
        return maxSub;
    }
    //left和right是未向左右移动前的index
    public boolean isLROK(String s,int left,int right){
        if(left == 0 || right == s.length()-1)
            return false;
        if(s.charAt(left-1) == s.charAt(right+1))
            return true;
        else
            return false;
    }
    public boolean isNextSame(String s,int curr){
        if(curr < s.length()-1 && s.charAt(curr) == s.charAt(curr+1))
            return true;
        else
            return false;
    }

}
