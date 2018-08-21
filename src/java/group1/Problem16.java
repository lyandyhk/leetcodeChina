package group1;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */

public class Problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int res = 0;
        int curr,x,y;
        int currTarget;
        //单次target相减后的数,有正负
        int currResult;
        for(int i=0;i<nums.length-2;i++){
            curr = nums[i];
            x = i + 1;
            y = nums.length - 1;
            currTarget = target - curr ;
            while(x<y){
                currResult = currTarget - nums[x] - nums[y];
                if(currResult == 0)
                    return nums[x] + nums[y] + curr;
                if(currResult < 0){
                    if(-1 * currResult < result){
                        result = -1 * currResult;
                        res = curr + nums[x] + nums[y];
                    }
                    y--;
                }
                else if(currResult > 0){
                    if(currResult < result){
                        result = currResult;
                        res = curr + nums[x] + nums[y];
                    }
                    x++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,1,55};
        System.out.println(threeSumClosest(arr,3));
    }
}
