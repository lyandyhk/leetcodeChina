package group1;

import java.util.*;

public class Problem20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        List<Character> inList = new ArrayList<>();
        inList.add('(');
        inList.add('[');
        inList.add('{');
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(char c : chars){
            if(inList.contains(c)){
                stack.push(c);
            }
            else if(map.containsKey(c)){
                if(stack.size() == 0 || map.get(c) != stack.pop())
                    return false;
            }
        }
        if(stack.size()>0)
            return false;
        return true;
    }
}
