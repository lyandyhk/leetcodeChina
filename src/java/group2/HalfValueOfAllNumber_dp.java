package group2;

public class HalfValueOfAllNumber_dp {
    public static int nearHalfOfAll(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum = sum + i;
        }

        int dp[][] = new int[nums.length+1][sum/2+1];
        for(int i=1;i<=nums.length;i++){
            int curr = nums[i-1];
            for(int j=0;j<sum/2+1;j++){
                if(j < nums[i-1]){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                int x = dp[i-1][j];
                int y = dp[i-1][j-nums[i-1]]+nums[i-1];
                dp[i][j] = Math.max(x,y);
            }

        }
        return dp[nums.length][sum/2];
    }

    public static void main(String[] args) {
        System.out.println(nearHalfOfAll(new int[]{5,7,11,28,85}));
    }
}
