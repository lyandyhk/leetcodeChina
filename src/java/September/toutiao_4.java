package September;

import java.util.Scanner;

/**
 * 头条0909-4:UTF-8的规则检验是否合理
 *              只有一个字节的话，该字节必须0打头
 *              n个字节的话，第一个字节必须n个1打头，然后后面以为必须是0，其他位字节必须10打头
 *              n最大为4
 *
 *
 *
 *              正常处理就好，对于给定数字转成的二进制字符串，如果小于8位，前面补0补到8位，如果大于8位，字符串截取截取最后面8位
 *              然后进行各个规则的判断就行。
 *
 */
public class toutiao_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>4){
            System.out.println(0);
            return;
        }
        String[] bytes = new String[n];
        for(int i=0;i<n;i++){
            bytes[i] = Integer.toBinaryString(sc.nextInt());
            if(bytes[i].length()<8){
                for(int k=bytes[i].length();k<8;k++){
                    bytes[i] = "0"+bytes[i];
                }
            }
            else if(bytes[i].length()>8){
                bytes[i] = bytes[i].substring(bytes[i].length()-8,bytes[i].length());
            }
        }
        if(bytes.length == 1){
            if(bytes[0].charAt(0) == '0'){
                System.out.println(1);
                return;
            }
        }
        else{
            int length = bytes.length;
            for(int i=0;i<length+1;i++){
                if(i != length){
                    if(bytes[0].charAt(i) != '1'){
                        System.out.println(0);
                        return;
                    }
                }
                if(i == length){
                    if(bytes[0].charAt(i) != '0'){
                        System.out.println(0);
                        return;
                    }
                }
            }
            for(int i=1;i<length;i++){
                if(bytes[i].charAt(0) != '1' || bytes[i].charAt(1) != '0'){
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(1);
            return;
        }


    }

}
