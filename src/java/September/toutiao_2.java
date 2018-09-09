package September;

import java.util.Scanner;

/**
 * 头条0909-2：遍历网格找最少部门数，连着的算一个部门，下面示例最少三个部门，1算存在，0算不存在
 *
 * 1 1 0 0 1
 * 1 0 0 0 1
 * 0 0 1 0 1
 * 0 0 1 0 0
 *
 * 广度遍历就完事了，不断向下向右，碰到1继续向下向右，碰到0或处理过的（处理过的部门设置为-1）继续遍历
 *
 */
public class toutiao_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        int[][] nums = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(nums[i][j] == 1){
                    findDown(nums,i,j);
                    findRight(nums,i,j);
                    ans++;
                }

            }
        }
        System.out.println(ans);
    }
    public static void findDown(int nums[][],int i,int j){
        if(i<nums.length-1){
            i = i+1;
            if(nums[i][j] == 1){
                nums[i][j] = -1;
                findRight(nums,i,j);
                findDown(nums,i,j);
            }
        }
    }
    public static void findRight(int nums[][],int i,int j){
        if(j<nums[i].length-1){
            j = j+1;
            if(nums[i][j] == 1){
                nums[i][j] = -1;
                findRight(nums,i,j);
                findDown(nums,i,j);
            }
        }
    }
}
