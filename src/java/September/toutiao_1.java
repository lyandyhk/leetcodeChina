package September;


/**
 * 头条0909-1：最长不重复字母字串，不多说了，碰到相同的就找到当前子字符串中这个字符的位置，这个字符和这个字符之前的所有字符都不要了，继续往后遍历
 */

import java.util.Scanner;

public class toutiao_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim();
        if(str == null || str.length() == 0){
            System.out.println(0);
            return;
        }

        if(str.length() == 1){
            System.out.println(1);
            return;
        }

        int ans = 1;
        int curr = 1;
        String currStr = "" + str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(currStr.contains(""+str.charAt(i))){

                currStr = currStr.substring(currStr.indexOf(""+str.charAt(i))+1,i)+str.charAt(i);
                curr = currStr.length();
            }
            else{
                currStr = currStr + str.charAt(i);
                curr++;
                if(ans < curr){
                    ans = curr;
                    System.out.println(currStr);
                }

            }
        }
        System.out.println(ans);
    }
}
