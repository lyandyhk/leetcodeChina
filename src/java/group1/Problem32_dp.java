package group1;

import java.util.Stack;

public class Problem32_dp {
    public static int longestValidParentheses(String s) {
        Stack<Structure> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(new Structure(c));
            }
            else if(c == ')'){
                if(stack.size() > 0){
                    if(stack.peek().c != null){
                        if(stack.peek().c == '('){
                            stack.pop();
                            stack.push(new Structure(2));
                            stack = checkDoubleLengthNum(stack);
                        }
                        else {
                            stack.push(new Structure(')'));
                        }
                    }
                    else {
                        Structure strLength = stack.pop();
                        if(stack.size() == 0){
                            stack.push(strLength);
                            stack.push(new Structure(')'));
                        } else {
                            if(stack.peek().c == '('){
                                stack.pop();
                                stack.push(new Structure(strLength.length + 2));
                                stack = checkDoubleLengthNum(stack);
                                continue;
                            } else {
                                stack.push(strLength);
                                stack.push(new Structure(')'));
                            }
                        }
                    }
                }
                else{
                    stack.push(new Structure(')'));
                }
            }
        }
        int result = 0;
        for(Structure structure : stack){
            if(structure.length != null && result < structure.length)
                result = structure.length;
        }
        return result;
    }
    public static Stack<Structure> checkDoubleLengthNum(Stack<Structure> stack){
        if(stack.size() == 1)
            return stack;
        Structure s1 = stack.pop();
        if(stack.peek().length != null){
            Structure s2 = stack.pop();
            stack.push(new Structure(s1.length+s2.length));
            return stack;
        } else {
            stack.push(s1);
            return stack;
        }
    }

}
class Structure {
    public Character c;
    public Integer length;

    public Structure(char c) {
        this.c = c;
    }

    public Structure(int length) {
        this.length = length;
    }
}
