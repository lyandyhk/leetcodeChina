package group2;

import java.util.*;

public class Toutiao_1_3 {
    public static void main(String[] args) {
        List<Set<Integer>> lists = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            int num = sc.nextInt();
            while(num != 0){
                set.add(num);
                num = sc.nextInt();
            }
            lists.add(set);
        }
        int mod = 0;
        while(true){
            mod = 0;
            for(int i=0;i<n;i++){
                Set set = lists.get(i);
                if(set.size() == 0)
                    continue;
                for(int j=i+1;j<n;j++){
                    if(lists.get(j).size() == 0)
                        continue;
                    if(compareTwoSet(lists.get(i),lists.get(j))){
                        mergeTwoSet(lists,i,j);
                        mod++;
                    }
                }
            }
            if(mod == 0)
                break;
        }
        int count = 0;
        for(Set set : lists){
            if(set.size()>0)
                count++;
        }
        System.out.println(count);
    }
    public static boolean compareTwoSet(Set<Integer> set1,Set<Integer> set2){
        for(int i1 : set1){
            if(set2.contains(i1))
                return true;
        }
        return false;
    }
    public static void mergeTwoSet(List<Set<Integer>> lists,int i,int j){
        lists.get(i).addAll(lists.get(j));
        lists.get(j).clear();
    }
}
