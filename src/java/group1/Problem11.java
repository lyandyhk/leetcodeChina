package group1;


/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */

public class Problem11 {
    public static int maxArea(int[] height) {
        int length = height.length;
        if(length < 2)
            return 0;
        if(length == 2)
            return height[0] < height[1]?height[0]:height[1];

        int currLenght = 0,currHeight = 0;
        int i = 0,j = length - 1,maxWater = 0,currWater = 0;
        while(i < j){
            currLenght = j - i;
            if(height[i] < height[j]){
                currHeight = height[i];
                i++;
            } else {
                currHeight = height[j];
                j--;
            }
            currWater = currLenght * currHeight;
            if(currWater > maxWater)
                maxWater = currWater;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
