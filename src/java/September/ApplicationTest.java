package September;
/**
 * 测试类，没啥意义
 */

import java.util.Scanner;
import java.util.Stack;

public class ApplicationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<String> stack = new Stack<>();
        String[] strs = str.split("/");
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals(""))
                continue;
            else if (strs[i].equals("..")) {
                if (stack.size() == 0)
                    continue;
                else
                    stack.pop();
            } else {
                stack.push(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String path : stack){
            sb.append(path);
            sb.append("/");
        }
        if(sb.length() != 1){
            System.out.println(sb.substring(0,sb.length()-1));
        }
        else
            System.out.println(sb);
    }
}
