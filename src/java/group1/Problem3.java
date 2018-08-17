package group1;

import java.util.LinkedList;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        char[] strs = s.toCharArray();

        int max = 0;
        for(int i=0;i<strs.length;i++){
            if(!list.contains(strs[i])){
                list.addFirst(strs[i]);
                max = list.size()>max?list.size():max;
            } else {
                int index = list.indexOf(strs[i]);
                removeFromIndex(list,index);
                list.addFirst(strs[i]);
            }
        }
        return max;
    }
    public void removeFromIndex(LinkedList list,int index){
        while(list.size()>index)
            list.removeLast();
    }
}
