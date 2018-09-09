package September;


import java.util.Scanner;

/**
 * 帮人做的美团0907的测试开发岗第三道题
 *
 * 现在小明有120分钟时间做题，现在有n道题，每道题他可以选择
 *                                                  1.不做，直接跳过，不得分
 *                                                  2.花短时间a，得部分分p
 *                                                  3.花长时间b，得全分q
 *
 * 请问小明最多得多少分
 *
 *
 *
 * 用动态规划解答，dp[m][n],m表示题数，n表示时间，dp[][]中存的是分数
 * 分三种情况，第一种是在短时间a以内的数，取当前位置的上面或者左边更大的数
 *           第二种是在短时间a以上，但是在长时间p以下，这时候就用当前位置“左边”或“上面”或“上面位置减去a，值加上p”取最大的
 *           第三种是在长时间p以上，这时候就用当前位置“左边”或“上面”或“上面位置减去a，值加上p”或“上面位置减去b，值加上q”取最大的
 * 取到dp[m][120]的值便是题目所求
 */
public class meituan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arg = new int[n][4];   // ai  pi  bi  qi   ai是pi时间的分，bi是qi时间的分
        for(int i=0;i<n;i++){           //  p   a   q  b
            for(int j=0;j<4;j++){
                arg[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[n][121];
        for(int i = 0;i<=120;i++){
            dp[0][i] = 0;
        }
        for(int i = 0;i<n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<n;i++) {
            for (int j = 1; j < 121; j++) {
                if(j<arg[i][0])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(j>=arg[i][0] && j<arg[i][2])
                    dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i-1][j-arg[i][0]]+arg[i][1]),dp[i][j-1]);
                if(j>= arg[i][2]){
                    dp[i][j] = Math.max(dp[i-1][j-arg[i][2]]+arg[i][3],Math.max(Math.max(dp[i-1][j],dp[i-1][j-arg[i][0]]+arg[i][1]),dp[i][j-1]));
                }

            }
        }
        System.out.println(dp[n-1][120]);
    }
}
