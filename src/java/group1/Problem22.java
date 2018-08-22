package group1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
         给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

         例如，给出 n = 3，生成结果为：

         [
         "((()))",
         "(()())",
         "(())()",
         "()(())",
         "()()()"
         ]
 *
 *
 *      解答：设置两个参数，当前字符串前面还需要中和的'('的个数needFix，剩余没使用的'('的个数remain
 *
 *           通过递归函数，处理4个逻辑
 *              1.如果前面即没有needFix,而且remain又为0，说明都处理完了，这时候输出字符串
 *              2.如果前面没有needFix,但是remain不为0，说明当前字符串是处理完成的，还有括号没加，这时候只在在字符串后面加上'(',而不能加')'
 *              3.如果前面有needFix，但是remain不为0，说明这时候加'('或者')'都是可以的，这时候就执行两次，一次加'('，一次加')'，不过要记得对应变量计数不要搞错
 *              4.如果前面有needFix，remain为0，说明已经不能再加'('了，因为已经加到上限了， 这时候只能加')'了
 */

public class Problem22 {
    public static List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        //前方有效的'('个数，如果被')'中和，那不算有效
        int needFix = 0;
        //还剩余的'('个数
        int remain = n;
        addLeftOrRight("",needFix,remain,set);
        for(String s : set){
            list.add(s);
        }
        return list;
    }
    public static void addLeftOrRight(String s,int needFix,int remain,Set<String> set){
        if(needFix == 0){
            if(remain == 0)
                set.add(s);
            else{
                s = s + '(';
                needFix++;
                remain--;
                addLeftOrRight(s,needFix,remain,set);
            }
        }
        else if(needFix > 0){
            if(remain>0)
                addLeftOrRight(s+"(",needFix+1,remain-1,set);
            addLeftOrRight(s+')',needFix-1,remain,set);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
