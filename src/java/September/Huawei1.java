package September;
/**
 * 26进制加减法
 */

import java.util.Scanner;

public class Huawei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String result = "";
        long sum = 0;
        long l1,l2;
        for(int i=0;i<str1.length();i++){
            int pos = str1.length() - i - 1;
            long s =  str1.charAt(i) - 97;
            sum += pow(s,pos);
        }
        for(int i=0;i<str2.length();i++){
            int pos = str2.length() - i - 1;
            long s =  str2.charAt(i) - 97;
            sum += pow(s,pos);
        }
        while(sum > 0){
            int temp = (int)(sum % 26);
            char curr = (char)(temp+97);
            result = curr + result;
            sum = sum / 26;
        }
        if(result.equals(""))
            System.out.println("a");
        else
            System.out.println(result);
    }
    public static long pow(long s,int pos){
        while(pos>0){
            s = s * 26;
            pos--;
        }

        return s;
    }
}
