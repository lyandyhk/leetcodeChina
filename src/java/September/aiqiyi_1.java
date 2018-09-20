package September;

import java.util.*;


public class aiqiyi_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> big,small;
        int sum1 = 0;
        int sum2 = 0;
        int need = 0;
        int count = 0;
        for(int i=0;i<3;i++){
            left.add(Integer.valueOf(""+num.charAt(i)));
            sum1 += Integer.valueOf(""+num.charAt(i));
            right.add(Integer.valueOf(""+num.charAt(i+3)));
            sum2 += Integer.valueOf(""+num.charAt(i+3));
        }
        if(sum1 == sum2){
            System.out.println(0);
            return;
        }
        else if(sum1 < sum2){
            big = right;
            small = left;
            need = sum2 - sum1;
        }
        else{
            small = right;
            big = left;
            need = sum1 - sum2;
        }
        Collections.sort(small);
        Collections.sort(big, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return -1;
                else if (o1<o2)
                    return 1;
                else
                    return 0;
            }
        });

        int i=0,j=0;
        while(i<3 && j<3){
            int bigNum = big.get(i);
            int smallNum = small.get(j);
            if(Math.abs(4.5-bigNum)>=Math.abs(4.5-smallNum)){
                if(need>bigNum){
                    need = need - bigNum;
                    count++;
                    i++;
                }
                else{
                    count++;
                    break;
                }
            }
            else{
                if(need>(9-smallNum)){
                    need = need - (9-smallNum);
                    count++;
                    j++;
                }
                else{
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);

    }
}
