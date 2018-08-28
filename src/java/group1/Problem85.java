package group1;

/**
 * 未做完，case不全通过，有bug
 */
public class Problem85 {
    public static void main(String[] args) {
        char[][] matrix = new char[4][4];
        matrix[0] = new char[]{'0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0'};
        matrix[1] = new char[]{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'};
        matrix[2] = new char[]{'1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1'};
        matrix[3] = new char[]{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1'};
        matrix[4] = new char[]{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1'};
        matrix[5] = new char[]{'1','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1'};
        matrix[6] = new char[]{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1'};
        matrix[7] = new char[]{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0'};
        matrix[8] = new char[]{'0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1'};
        matrix[9] = new char[]{'1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1'};
        matrix[10] = new char[]{'1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1'};
        matrix[9] = new char[]{'1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'};
        matrix[9] = new char[]{'0','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'};
        matrix[9] = new char[]{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1'};
        System.out.println(maximalRectangle(matrix));
        int [][] a = new int[][]{};

    }
    public static int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] dp = new int[x][y];
        Point[][] dpPoint = new Point[x][y];
        if(matrix[0][0] == '1'){
            dp[0][0] = 1;
            dpPoint[0][0] = new Point(1,1);
        }
        else
            dpPoint[0][0] = new Point(0,0);
        if(dp[0][0] > max)
            max = dp[0][0];
        for(int i = 1;i<x;i++){
            if(matrix[i][0] == '0'){
                dp[i][0] = 0;
                dpPoint[i][0] = new Point(0,0);
            }
            else{
                dp[i][0] = dp[i-1][0] + 1;
                dpPoint[i][0] = new Point(1,dpPoint[i-1][0].height+1);
                if(dp[i][0] > max)
                    max = dp[i][0];
            }
        }
        for(int i = 1;i<y;i++){
            if(matrix[0][i] == '0'){
                dp[0][i] = 0;
                dpPoint[0][i] = new Point(0,0);
            }
            else{
                dp[0][i] = dp[0][i-1] + 1;
                dpPoint[0][i] = new Point(dpPoint[0][i-1].length+1,1);
                if(dp[0][i] > max)
                    max = dp[0][i];
            }
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    dpPoint[i][j] = new Point(0,0);
                } else {
                    int Area1 = 1;
                    int Area2 = 1;
                    Point point1 = new Point(1,1);
                    Point point2 = new Point(1,1) ;
                    //第一种只有左边
                    if(dp[i][j-1] != 0){
                        if(dpPoint[i][j-1].height <= dpPoint[i-1][j].height+1){
                            Area1 = dpPoint[i][j-1].height * (dpPoint[i][j-1].length + 1);
                            point1 = new Point(dpPoint[i][j-1].length + 1,dpPoint[i][j-1].height);
                        }

                        else{
                            Area1 = (dpPoint[i-1][j].height+1) * (dpPoint[i][j-1].length + 1);
                            point1 = new Point(dpPoint[i][j-1].length + 1,dpPoint[i-1][j].height+1);
                        }
                    }
                    //第二种只有上面
                    if(dp[i-1][j] != 0){
                        if(dpPoint[i-1][j].length <= dpPoint[i][j-1].length+1){
                            Area2 = dpPoint[i-1][j].length * (dpPoint[i-1][j].height + 1);
                            point2 = new Point(dpPoint[i-1][j].length,(dpPoint[i-1][j].height + 1));
                        }
                        else{
                            Area2 = (dpPoint[i][j-1].length+1) * (dpPoint[i-1][j].height + 1);
                            point2 = new Point((dpPoint[i][j-1].length+1),(dpPoint[i-1][j].height + 1));
                        }
                    }
                    if(Area1>Area2){
                        dp[i][j] = Area1;
                        dpPoint[i][j] = point1;
                        if(Area1 > max)
                            max = Area1;
                    } else {
                        dp[i][j] = Area2;
                        dpPoint[i][j] = point2;
                        if(Area2 > max)
                            max = Area2;
                    }
                }
            }
        }
        return max;
    }
}
class Point{
    int length;
    int height;

    public Point(int length, int height) {
        this.length = length;
        this.height = height;
    }
}