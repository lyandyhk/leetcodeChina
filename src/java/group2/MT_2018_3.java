package group2;

import java.util.Scanner;

public class MT_2018_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(maxArea(nums));

    }
    public static int maxArea(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int minLength = nums[i];
            int currArea = minLength;
            if(currArea>max)
                max = currArea;
            for(int j = i+1;j<nums.length;j++){
                if(minLength>nums[j])
                    minLength = nums[j];
                currArea = (j - i+1) * minLength;
                if(currArea > max)
                    max = currArea;
            }
        }
        return max;
    }
}
