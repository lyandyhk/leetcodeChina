package September;
/**
 * 去掉不幸运数字的最小数字
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class BOSS_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long buy = sc.nextInt();
        if(buy<0)
            buy = 0;
        String str = sc.next();
        String[] unlucks = str.split(",");
        Set<String> set = new HashSet<>();
        for(String s : unlucks){
            set.add(s);
        }
        set.add("0");
        for(;;){
            String curr = "" + buy;
            boolean isRight = true;
            for(String s : set){
                if(curr.contains(s)){
                    isRight = false;
                    break;
                }
            }
            if(isRight){
                System.out.println(curr);
                return;
            }
            buy++;
        }

    }
}
