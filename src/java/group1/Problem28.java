package group1;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 * 注意：未处理haystack与needle为null的情况，只处理了""空字符串的情况
 */
public class Problem28 {
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        boolean isAllRight = true;
        for(int i=0;i<haystacks.length;i++){
            if(haystacks.length - i < needles.length)
                return -1;
            for(int j=0;j<needles.length;j++){
                char ne = needles[j];
                char ha = haystacks[i+j];
                if(needles[j] == haystacks[i+j])
                    continue;
                else{
                    isAllRight = false;
                    break;
                }

            }
            if(isAllRight)
                return i;
            isAllRight = true;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }
}