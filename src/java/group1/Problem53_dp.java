package group1;



/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * [-3,-5,-1]
 * [-5,-3,-1]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 */
public class Problem53_dp {
    public static int maxSubArray(int[] nums) {
        //先找负数，如果全是负数的话，那么就返回最小的负数
        if(AllLessZero(nums)){
            int max = nums[0];
            for(int num : nums){
                if(num > max)
                    max = num;
            }
            return max;
        }
        //如果不全是负数，那么只要碰到sum为负数的情况就抛弃前面的sum，重新计算sum
        //不要让max和sum先去第一个数，这样如果第一个数是负数的话还要加其他逻辑

        //当前curr之前的sum都大于等于0，这是前提条件，所以对于curr是正数，而sum是负数，sum+nums[curr]为正数的情况不需要讨论
        int max = 0;
        int sum = 0;
        int curr = 0;
        while(curr<nums.length){
            if(nums[curr] + sum <= 0){
                curr++;
                sum = 0;
            }
            else {
                sum = nums[curr] + sum;
                curr++;
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }
    public static boolean AllLessZero(int[] nums){
        for(int num : nums){
            if(num >= 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1,1,2,1}));
    }
}
