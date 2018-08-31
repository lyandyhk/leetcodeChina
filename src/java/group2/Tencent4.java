package group2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tencent4 {
    public static long[][] initNums = new long[105][105];
    static{
        initNums[0][0] = 1;
        for(int i=1;i<101;i++){
            initNums[i][0] = 1;
            for(int j=1;j<101;j++){
                initNums[i][j] = (initNums[i-1][j-1] + initNums[i-1][j]) % 1000000007;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int Alength = sc.nextInt();
        int Acount = sc.nextInt();
        int Blength = sc.nextInt();
        int Bcount = sc.nextInt();
        List<Point> list = getList(k,Alength,Blength,Acount,Bcount);
        long sum = 0;
        for(Point point : list){
            long now = initNums[Acount][point.Acount];
            now = initNums[Bcount][point.Bcount] * now;
            if(now > 1000000007)
                now = now % 1000000007;
            sum = sum + now;
            if(sum > 1000000007)
                sum = sum % 1000000007;
        }
        System.out.println(sum);
    }
    public static List<Point> getList(int k,int Alength,int Blength,int Atimes,int Btimes){
        List<Point> list = new ArrayList<>();
        if(k % Alength == 0 && k/Alength <= Atimes)
            list.add(new Point(k/Alength,0));
        for(int i=0;i<=Atimes;i++){
            int AsumLength = Alength * i;
            if(k-AsumLength < Blength){
                break;
            }
            int Bneed = (k-AsumLength) / Blength;
            int Bmod = (k-AsumLength) % Blength;
            if(Bmod == 0 && Bneed <= Btimes){
                list.add(new Point(i,Bneed));
            }
        }
        return list;
    }

}
class Point{
    int Acount;
    int Bcount;

    public Point(int acount, int bcount) {
        Acount = acount;
        Bcount = bcount;
    }
}