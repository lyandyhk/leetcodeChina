package group1;

import java.util.*;

public class Problem30 {
    public static List<String> allWord = new ArrayList<>();
    public static List<Integer> findSubstring(String s, String[] words) {
        List<String> list = new ArrayList<>();
        for(String str : words){
            list.add(str);
        }
        getFullWordStringList("",list);
        Set<String> wordSet = new HashSet<>(allWord);
        allWord.clear();
        Set<Integer> indexSet = new HashSet<>();
        for(String word : wordSet){
            indexSet.addAll(getAllRightIndex(s,word));
        }
        return new ArrayList<>(indexSet);
    }
    public static void getFullWordStringList(String str,List<String> words){
         for(String word : words){
             List<String> newWords = new ArrayList<>(words);
             newWords.remove(word);
             String next = str + word;
             if(newWords.size() == 0){
                 allWord.add(next);
                 return;
             }
             getFullWordStringList(next,newWords);

         }
    }
    public static Set<Integer> getAllRightIndex(String s,String sub){
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while(i != -1){
            i = s.indexOf(sub,i);
            if(i == -1)
                break;
            if(i != -1)
                set.add(i);
            i++;
        }
        return set;
    }
    public static void main(String[] args) {
        String[] strs = {"foo","bar"};
        findSubstring("barfoothefoobarman",strs);

    }
}
