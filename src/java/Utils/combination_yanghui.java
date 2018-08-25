package Utils;

public class combination_yanghui {
    //大小自己设置
    public static long[][] initNums = new long[105][105];
    public static long MOD = 1000000007;

    //取数的话，C上面的数在第二维上，C下面的基数在第一维上.
    static{
        initNums[0][0] = 1;
        for(int i=1;i<101;i++){
            initNums[i][0] = 1;
            for(int j=1;j<101;j++){
                initNums[i][j] = (initNums[i-1][j-1] + initNums[i-1][j]) % MOD;
            }
        }
    }
}
