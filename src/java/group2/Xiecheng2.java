package group2;


import java.util.*;

public class Xiecheng2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int target = sc.nextInt();
        LinkedHashMap<Integer,Record> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            int id = sc.nextInt();
            int begin = sc.nextInt();
            int end = sc.nextInt();
            map.put(id,new Record(begin,end));
        }
        for(Integer id : map.keySet()){
            Record record = map.get(id);
            if(record.begin<=target && record.end>=target){
                list.add(id);
            }
        }
        if(list.size() == 0)
            System.out.println("null");
        else{
            Collections.sort(list);
            while(list.size()>0)
                System.out.println(list.remove(0));
        }
    }
}

class Record{
    public int begin;
    public int end;
    public Record(int begin,int end){
        this.begin = begin;
        this.end = end;
    }
}