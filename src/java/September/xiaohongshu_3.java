package September;

import java.util.*;

/**
 * 笔试编程题模板
 */

public class xiaohongshu_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<CRecord> records = new ArrayList<>();
        for(int i=0;i<m;i++){
            records.add(new CRecord(sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(records, new Comparator<CRecord>() {
            @Override
            public int compare(CRecord o1, CRecord o2) {
                if(o1.id>o2.id)
                    return 1;
                else if(o1.id<o2.id)
                    return -1;
                else
                    return 0;
            }
        });
        boolean flag = true;
        for(int i=0;i<records.size();i++){
            int id = records.get(i).id;
            int dislike = records.get(i).dislike;
            if(!(left.contains(id) || right.contains(id))){
                left.add(id);
                right.add(dislike);
            }
            else if(left.contains(id)){
                if(left.contains(dislike)){
                    if(flag){
                        change(left,right,records,id,i);
                        i--;
                        flag = false;
                        continue;
                    }
                    else{
                        System.out.println(0);
                        return;
                    }



                }
                else{
                    if(right.contains(dislike))
                        continue;
                    else
                        right.add(dislike);
                }
            }
            else{
                if(right.contains(dislike)){
                    if(flag){
                        change(left,right,records,id,i);
                        i--;
                        flag = false;
                        continue;
                    }
                    else{
                        System.out.println(0);
                        return;
                    }
                }
                else{
                    if(left.contains(dislike))
                        continue;
                    else
                        left.add(dislike);
                }
            }
        }
        System.out.println(1);
    }
    public static void change(List<Integer> left,List<Integer> right,List<CRecord> records,int id,int pos){
        for(int i=0;i<pos;i++){
            CRecord record = records.get(i);
            if(record.id == id || record.dislike == id){
                if(left.contains(id)){
                    left.remove(new Integer(id));
                    right.remove(new Integer(record.dislike));
                    left.add(new Integer(record.dislike));
                    right.add(new Integer(id));
                    return;
                }
                else{
                    right.remove(new Integer(id));
                    left.remove(new Integer(record.dislike));
                    right.add(new Integer(record.dislike));
                    left.add(new Integer(id));
                    return;
                }
            }
        }
    }
}
class CRecord{
    int id;
    int dislike;
    public CRecord(int id,int dislike){
        this.id = id;
        this.dislike = dislike;
    }
}
