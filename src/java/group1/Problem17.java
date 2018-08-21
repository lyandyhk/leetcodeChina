package group1;

import java.util.*;

/**
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Problem17 {
    public static Map<Character,char[]> map = new HashMap<>();
    static{
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
    }
    public static List<String> letterCombinations(String digits) {
        Queue<String> que = new LinkedList<>();
        if(digits.length() == 0)
            return (LinkedList<String>) que;
        que.offer("");
        char[] chars = digits.toCharArray();
        for(char c : chars){
            que = convertNumToWord(que,c);
        }
        return (LinkedList<String>) que;
    }

    public static Queue<String> convertNumToWord(Queue<String> queue,char c){
        Queue<String> que = new LinkedList<>();
        char[] targets = map.get(c);
        while(queue.size()>0){
            String s = queue.poll();
            for(char target : targets){
                que.offer(s + target);
            }
        }
        return que;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
