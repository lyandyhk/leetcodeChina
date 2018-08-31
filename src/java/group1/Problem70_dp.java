package group1;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Problem70_dp {
    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int[] methods = new int[n+1];
        methods[0] = 1;
        methods[1] = 1;
        climbStairsUseOneArr(methods);
        return methods[methods.length-1];
    }
    public static void climbStairsUseOneArr(int[] methods){
        for(int i = 2;i < methods.length;i++){
            methods[i] = methods[i-1] + methods[i-2];
        }
    }

}
