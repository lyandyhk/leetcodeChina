package September;

/**
 * 两个字符串找重复
 * 输入为两个字符串A和B，找B中的所有元素是不是在A中出现过，全都出现过输出true，否则输出false
 */

import java.util.HashSet;
import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        boolean flag = true;
        for(int i=0;i<str1.length();i++){
            set1.add(str1.charAt(i));
        }
        for(int i=0;i<str2.length();i++){
            set2.add(str2.charAt(i));
        }
        for(Character c : set2){
            if(set1.contains(c))
                continue;
            else{
                System.out.println("false");
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("true");
    }
}
