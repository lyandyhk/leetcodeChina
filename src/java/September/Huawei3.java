package September;

import java.util.*;

/**
 * 输入一个字符串，其中是一串字符串一个数字一串字符串一个数字的形式，表示数字前的那个字符串的出现次数
 * 最后输出规则是：次数由小到大牌，次数一样的话按ASCII升序排
 *
 * 例如输入：a11b2bac3bad3abcd2
 *    输出：abcdabcdbbbacbacbacbadbadbadaaaaaaaaaaa
 */
public class Huawei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Record> list = new ArrayList<>();
        String str = sc.nextLine();
        String sub = "";
        boolean lastIsWord = true;
        int pos = 0;
        for(int i=0;i<str.length();i++){

            if(Character.isDigit(str.charAt(i))){
                if(lastIsWord){
                    sub = str.substring(pos,i);
                    pos = i;
                    lastIsWord = false;
                }
                if(i == str.length()-1){
                    int count = Integer.valueOf(str.substring(pos,i+1));
                    list.add(new Record(count,sub));
                    break;
                }
            }
            else{
                if(!lastIsWord){
                    int count = Integer.valueOf(str.substring(pos,i));
                    list.add(new Record(count,sub));
                    pos = i;
                    lastIsWord = true;
                }
            }
        }
        Collections.sort(list, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                if(o1.count>o2.count)
                    return 1;
                else if(o1.count<o2.count)
                    return -1;
                else{
                    int length = o1.str.length()>o2.str.length()?o2.str.length():o1.str.length();
                    for(int i=0;i<length;i++){
                        if(o1.str.charAt(i)>o2.str.charAt(i))
                            return 1;
                        else if(o2.str.charAt(i)>o1.str.charAt(i))
                            return -1;
                        else{
                            continue;
                        }
                    }
                    if(o1.str.length()>length)
                        return 1;
                    else if (o2.str.length()>length)
                        return -1;
                    else
                        return 0;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Record record : list){
            for(int i=0;i< record.count;i++){
                sb.append(record.str);
            }
        }
        System.out.println(sb.toString());
    }
}
class Record{
    public int count;
    public String str;
    public Record(int count,String str){
        this.count = count;
        this.str = str;
    }
}
