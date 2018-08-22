package group1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 解答：与三元找相同一样，只是多了一层for而已，原来是一个fix，现在在一个fix时，再循环第二个fix，remain = target - fix1 - fix2；
 */

public class Problem18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length<4)
            return lists;
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int remain = target - nums[i] - nums[j];
                int left = j+1,right = nums.length - 1;
                while(left < right){
                    if(nums[left] + nums[right] == remain){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        left++;
                        right--;
                        //左右各缩1个单位之后，有可能会出现缩了之后和缩了之前是同样的数的情况，这种情况要继续缩
                        while(left < right){
                            if(!(nums[left-1] == nums[left] && nums[right+1] == nums[right]))
                                break;
                            left++;
                            right--;
                        }
                    }
                    else if (nums[left] + nums[right] < remain){
                        left++;
                    }
                    else {
                        right--;
                    }
                }
                //对于遍历时相同的j，直接就跳过，因为当前i、j组合肯定与后续的组合是存在的
                while((j<nums.length-3 && nums[j] == nums[j+1]))
                    j++;
            }
            //对于遍历时相同的i，直接就跳过，因为当前i组合肯定与后续的组合是存在的
            while((i<nums.length-4 && nums[i] == nums[i+1]))
                i++;
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0));
    }
}
