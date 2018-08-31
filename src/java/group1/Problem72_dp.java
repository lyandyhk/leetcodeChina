package group1;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Problem72_dp {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++)
            dp[i][0] = i;
        for(int i=0;i<=word2.length();i++)
            dp[0][i] = i;

        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                int cost = word1.charAt(i-1) == word2.charAt(j-1)?0:1;
                dp[i][j] = Math.min(dp[i-1][j-1] + cost,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention","execution"));
    }
}
