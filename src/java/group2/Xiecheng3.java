package group2;

import java.util.*;

public class Xiecheng3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList();
        int size = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        String line = null;
        sc.nextLine();
        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] strs = line.split(" ");
            char action = strs[0].charAt(0);
            if(action == 'g'){
                int key = Integer.valueOf(strs[1]);
                if(map.containsKey(key)){
                    System.out.println(map.get(key));
                    list.remove(key-1);
                    list.addFirst(key);
                } else {
                    System.out.println(-1);
                }

            } else {
                int key = Integer.valueOf(strs[1]);
                int value = Integer.valueOf(strs[2]);
                if(map.containsKey(key)){
                    map.put(key,value);
                }else{
                    if(map.size() == size){
                        int rmKey = list.get(size-1);
                        list.remove(size-1);
                        map.remove(rmKey);
                        list.addFirst(key);
                        map.put(key,value);
                    } else {
                        map.put(key,value);
                        list.addLast(key);
                    }
                }
            }
        }
    }
}
class Node{
    int key;
    int value;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}