package September;


/**
 * 字符串中的最大数字
 */

import java.util.Scanner;



public class BOSS_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String max = "0";
        String curr = "";
        boolean isnowFirst = true;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!Character.isDigit(c)){
                max = getMax(max,curr);
                curr = "";
                isnowFirst = true;
            }
            else{
                if(c == '0'){
                    if(isnowFirst)
                        continue;
                    else{
                        curr = curr + c;
                    }
                }
                else{
                    curr = curr + c;
                    isnowFirst = false;
                }
            }
        }
        if(curr.length() != 0)
            max = getMax(max,curr);
        System.out.println(max);

    }
    public static String getMax(String max,String curr){
        if(max.length() > curr.length())
            return max;
        else if(max.length() < curr.length())
            return curr;
        else{
            return Integer.valueOf(max)>Integer.valueOf(curr)?max:curr;
        }

    }
}
