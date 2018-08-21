package group1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 *
 * 解答：重点在于不重复，用map来统计相同数字存在的次数将会非常耗时并且还要加很多判断逻辑
 *
 *      1.对原数组进行从小到大排序
 *      2.遍历数组，每次取得那个数当做fix，0-fix便是剩余两数相加的target，可以用两个指针指向fix之后的数组的头和尾，相加之和等于target便存入数组，并且头尾指针各往中间缩1.
 *      如果小于target，头指针加1；如果大于target，尾指针减一
 *
 * 注意点： 1.对于每次的fix，头尾指针从后面找，而不是每一次都从数组的头尾进行，一开始我硬是想不通为什么不是从数组头尾，难道不会漏掉吗？后来换了个思路
 *         如果第一个fix遍历结束，也就意味着包含fix的所有组合都应该结束了，所以后续fix的遍历就不应该包当前fix。
 *         2.当fix>0时，就不用做了，因为我们本来就排了序，大于0的数加上两个大于0的数不可能等于0
 *         3.当fix遍历后续头尾指针，找到一组符合条件的头尾指针后，这时候头尾指针各缩1，这个时候可能这两个数和刚刚的头尾指针对于的数是相同的，这个情况要继续跳过。
 *
 */
public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length<3)
            return lists;
        Arrays.sort(nums);

        //curr为当前fix，x为头指针，y为尾指针，lastx为当前fix的上一次遍历时的头指针索引
        int curr,x,y,target,lastx;
        for(int i=0;i<nums.length-2;i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            curr = nums[i];
            if(curr > 0)
                return lists;
            x = i + 1;
            y = nums.length - 1;
            target = 0 - curr;
            //不用正数是怕巧合出错
            lastx = -1;
            while(x<y){
                if(nums[x] + nums[y] == target){
                    //只需要判断一个指针与上一次是否相同就可以了，不需要x,y两个
                    if(lastx != -1 && nums[lastx] == nums[x]){
                        x++;
                        y--;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[x]);
                    list.add(nums[y]);
                    lists.add(list);
                    lastx = x;
                    x++;
                    y--;
                    continue;
                }
                else if(nums[x] + nums[y] < target)
                    x++;
                else
                    y--;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
