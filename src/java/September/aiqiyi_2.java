package September;

import java.util.*;


public class aiqiyi_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        List<Food> list = new ArrayList<>();
        list.add(new Food(0,-1));
        for(int i=1;i<n+1;i++){
            int nums = sc.nextInt();
            list.add(new Food(i,nums));
        }
        sc.nextLine();
        for(int i=0;i<m;i++){
            String[] str = sc.nextLine().split(" ");
            int id = Integer.valueOf(str[1]);
            if("A".equals(str[0])){
                Food food = list.get(id);
                food.num = food.num+1;
                list.set(id,food);
            }
            else{
                Food food = list.get(id);
                food.num = food.num-1;
                list.set(id,food);
            }
        }
        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                if(o1.num>o2.num)
                    return -1;
                else if(o1.num<o2.num)
                    return 1;
                else
                    return 0;
            }
        });
        int rank = getRank(list,p);
        System.out.println(rank);
    }
    public static int getRank(List<Food> list,int p){
        for(int i=0;i<list.size();i++){
            if(list.get(i).id == p)
                return i+1;
        }
        return -1;
    }
}
class Food{
    int id;
    int num;
    public Food(int id,int num){
        this.id = id;
        this.num = num;
    }
}