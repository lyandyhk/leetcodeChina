package September;

import java.util.Scanner;

/**
 * 头条0909-3:ip地址最大情况数，对给定的数字字符串进行判断最大可能的ip个数
 * 例如：10001可能情况就一种10.0.0.1
 *
 *
 * 暴力遍历：对“.”加的地方进行暴力循环，但是每次进行更下一层循环的时候判断自己是否合理，合理才继续，能减少很多时间
 *      对于第一与第四段数字，必须不能是0打头，并且数字少于4位，并且小于255.
 *      对于第二与第三段数字，如果是0打头，那它一定只能是0，如果位数超过1，那肯定错误，并且二三段的数字必须也是小于4位，但是可以等于255
 *
 */
public class toutiao_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = 0;
        if(s.length()<4 || s.length()>12){
            System.out.println(0);
            return;
        }
        char[] ip = s.toCharArray();
        for(int i=0;i<s.length()-3;i++){
            String ip1 = s.substring(0,i+1);
            if(!isIPTrue(ip1,true))
                continue;
            else{
                for(int j=i+1;j<s.length()-2;j++){
                    String ip2 = s.substring(i+1,j+1);
                    if(!isIPTrue(ip2,false)){
                        continue;
                    }
                    else{
                        for(int k=j+1;k<s.length()-1;k++){
                            String ip3 = s.substring(j+1,k+1);
                            if(!isIPTrue(ip3,false)){
                                continue;
                            }
                            else{
                                String ip4 = s.substring(k+1,s.length());
                                if(!isIPTrue(ip4,true)){
                                    continue;
                                }
                                else{
                                    System.out.println(ip1+"."+ip2+"."+ip3+"."+ip4);
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static boolean isIPTrue(String ips,boolean isTrim){
        if(isTrim){
            return !(ips.startsWith("0") || ips.length()>3 || Integer.valueOf(ips)>254);
        }
        else{
            return !((ips.startsWith("0")&&ips.length()>1) || ips.length()>3 || Integer.valueOf(ips)>255);
        }
    }
}
