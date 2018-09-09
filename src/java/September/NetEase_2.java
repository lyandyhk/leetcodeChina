package September;

import java.util.Scanner;

/**
 * 网易0908-2：找邻居
 */
public class NetEase_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] nums = new int[n][2];
        int [][] result = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            result[i][0] = 0;
            int live = nums[i][1];
            int notLive = nums[i][0] - nums[i][1];
            if(live>notLive)
                result[i][1] = notLive;
            else{
                if(live == 0 || live == 1)
                    result[i][1] = 0;
                else
                    result[i][1] = live-1;
            }
        }
        for(int i = 0;i<result.length;i++)
            System.out.println(result[i][0]+" "+result[i][1]);
    }
}
