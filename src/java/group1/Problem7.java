package group1;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
    public static int reverse(int x) {

        if(x == Integer.MIN_VALUE || x == 0)
            return 0;

        List<Integer> maxList = convertPositiveNumberToList(Integer.MAX_VALUE);

        //如果小于0，在最后要做符号处理
        boolean lessThanZero = false;
        if(x < 0){
            lessThanZero = true;
            x = x * (-1);
        }
        List<Integer> list = convertPositiveNumberToList(x);
        //参数List做翻转之后的开头index
        int currLength = 0;
        //maxIntegerList的开头index
        int currMaxLength = list.size()-1;

        StringBuilder sb = new StringBuilder("");
        //负号处理
        if(lessThanZero){
            sb.append("-");
        }
        for(Integer num : list){
            sb.append(num);
        }
        if(list.size()>maxList.size()){
            return 0;
        } else if (list.size()<maxList.size()) {
            return Integer.valueOf(sb.toString());
        } else {
            while(currMaxLength>0){
                int curr = list.get(currLength);
                int currMax = maxList.get(currMaxLength);
                if(curr > currMax)
                    return 0;
                else if(curr < currMax){
                    return Integer.valueOf(sb.toString());
                } else {
                    currLength++;
                    currMaxLength--;
                    continue;
                }
            }
            return Integer.valueOf(sb.toString());
        }
    }

    //将int转化为list，每位存一个位数，并且是倒序
    public static List convertPositiveNumberToList(int s){
        if(s<0)
            return null;
        List<Integer> list = new ArrayList<>();
        int single;
        while(s > 0){
            single = s % 10;
            s = s/10;
            list.add(single);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }
}
