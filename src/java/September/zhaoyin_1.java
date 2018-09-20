package September;

import java.util.*;


public class zhaoyin_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String children = sc.nextLine();
        String candys = sc.nextLine();
        String[] childrenStr = children.split(" ");
        String[] candysStr = candys.split(" ");
        int count = 0;

        LinkedList<Integer> childrenQueue = new LinkedList<>();
        LinkedList<Integer> candysQueue = new LinkedList<>();

        for(int i=0;i<childrenStr.length;i++){
            childrenQueue.add(Integer.valueOf(childrenStr[i]));
        }
        for(int i=0;i<candysStr.length;i++){
            candysQueue.add(Integer.valueOf(candysStr[i]));
        }
        Collections.sort(childrenQueue, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else if(o1<o2)
                    return -1;
                else
                    return 0;
            }
        });
        Collections.sort(candysQueue, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else if(o1<o2)
                    return -1;
                else
                    return 0;
            }
        });
        int length = Math.min(childrenStr.length,candysStr.length);

        while(!(candysQueue.isEmpty() ||childrenQueue.isEmpty())){
            int currCandy = candysQueue.peek();
            int currChlid = childrenQueue.peek();
            if(currCandy>=currChlid){
                candysQueue.poll();
                childrenQueue.poll();
                count++;
            }
            else{
                candysQueue.poll();
            }
        }
        System.out.println(count);
    }
}

