package group1;

public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int realIndex = 0;
        int currIndex = 0;
        int currInt = Integer.MAX_VALUE;
        while(currIndex < nums.length){
            if(nums[currIndex] != currInt){
                currInt = nums[currIndex];
                nums[realIndex++] = nums[currIndex++];
            } else
                currIndex++;
        }
        return realIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,4,5,5,5,32};
        System.out.println(removeDuplicates(nums));
    }
}
