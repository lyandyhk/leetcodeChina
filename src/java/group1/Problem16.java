package group1;

import java.util.Arrays;

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
