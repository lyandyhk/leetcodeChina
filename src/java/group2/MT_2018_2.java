package group2;

import java.math.BigInteger;
import java.util.Scanner;

public class MT_2018_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {1,5,10,20,50,100};
        long dp[][] = new long[6][n+1];
        for(int i=0;i<n+1;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<6;i++){
            dp[i][0] = 1;
            for(int j=1;j<n+1;j++){
                if(j<coins[i])
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }
        System.out.println(dp[5][n]);
    }
}
