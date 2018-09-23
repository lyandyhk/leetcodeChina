package September;

/**
 * 合法算数表达式
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BOSS_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        int leftCount = 0;
        if(str.length() == 0){
            System.out.println("True");
            return;
        }
        if(str.length() == 1){
            if(list.contains(str)){
                System.out.println("False");
                return;
            }
            else{
                System.out.println("True");
                return;
            }

        }

        for(int i=1;i<str.length();i++){
            char c = str.charAt(i);
            char l = str.charAt(i-1);
            if(Character.isDigit(c)){
                if(Character.isDigit(l))
                    continue;
                else if(list.contains("" + l))
                    continue;
                else if(l == '(')
                    continue;
                else{
                    System.out.println("False");
                    return;
                }
            }
            else if(list.contains("" + c)){
                if(Character.isDigit(l))
                    continue;
                else if(list.contains("" + l)){
                    System.out.println("False");
                    return;
                }
                else if(l == '('){
                    System.out.println("False");
                    return;
                }
                else
                    continue;
            }
            else if(c == '('){
                leftCount++;
                if(Character.isDigit(l)){
                    System.out.println("False");
                    return;
                }
                else if(list.contains("" + l)){
                    continue;
                }
                else if(l == '('){
                    continue;
                }
                else{
                    System.out.println("False");
                    return;
                }

            }
            else{
                if(leftCount<1){
                    System.out.println("False");
                    return;
                }
                leftCount--;
                if(Character.isDigit(l))
                    continue;
                else if(list.contains("" + l)){
                    System.out.println("False");
                    return;
                }
                else if(l == '('){
                    System.out.println("False");
                    return;
                }
                else{
                    continue;
                }
            }
        }
        if(leftCount != 0){
            System.out.println("False");
            return;
        }

        System.out.println("True");
    }
}
