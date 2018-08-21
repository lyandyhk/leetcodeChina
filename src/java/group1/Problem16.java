package group1;

import java.util.Arrays;

public class Problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int realResult = -1,singleRealResult = -1;
        //最后的差值最小的值
        int result = -1;

        //单趟的最小差值
        int singleAbsResult = -1;
        int curr,x,y;
        int currTarget;
        //单次target相减后的数,有正负
        int currResult;
        for(int i=0;i<nums.length-2;i++){
            curr = nums[i];
            x = i + 1;
            y = nums.length - 1;
            currTarget = target - curr ;
            currResult = currTarget - nums[x] - nums[y];
            if(currResult == 0)
                return nums[x] + nums[y] + curr;
            singleAbsResult = Math.abs(currResult);
            singleRealResult = nums[x] + nums[y] + curr;
            while(x<y){
                currResult = currTarget - nums[x] - nums[y];
                if(currResult == 0)
                    return nums[x] + nums[y] + curr;
                if(currResult < 0){
                    if(Math.abs(currResult) < singleAbsResult){
                        singleAbsResult = Math.abs(currResult);
                        singleRealResult = nums[x] + nums[y] + curr;
                    }
                    y--;
                    continue;
                }
                if(currResult > 0){
                    if(Math.abs(currResult) < singleAbsResult){
                        singleAbsResult = Math.abs(currResult);
                        singleRealResult = nums[x] + nums[y] + curr;
                    }
                    x++;
                    continue;
                }
            }
            if(result == -1){
                result = singleAbsResult;
                realResult = singleRealResult;
                continue;
            } else if(singleAbsResult < result){
                result = singleAbsResult;
                realResult = singleRealResult;
            }
        }
        return realResult;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,1,-3};
        System.out.println(threeSumClosest(arr,1));
    }
}
