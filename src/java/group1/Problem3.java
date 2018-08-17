package group1;

import java.util.LinkedList;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        char[] strs = s.toCharArray();

        int max = 0;
        for(int i=0;i<strs.length;i++){
            if(!list.contains(strs[i])){
                list.addFirst(strs[i]);
                max = list.size()>max?list.size():max;
            } else {
                int index = list.indexOf(strs[i]);
                removeFromIndex(list,index);
                list.addFirst(strs[i]);
            }
        }
        return max;
    }
    public void removeFromIndex(LinkedList list,int index){
        while(list.size()>index)
            list.removeLast();
    }
}
