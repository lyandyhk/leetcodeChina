package September;

import java.util.*;

/**
 * 网易0908-3：糖果投票，未做
 */
public class NetEase_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int voteCount = sc.nextInt();
        int candidateCount = sc.nextInt();
        int Num1Couunt = 0;
        int sum = 0;
        List<LinkedList<Integer>> allVoteMan = new ArrayList<>(candidateCount+1);
        for(int i=0;i<candidateCount+1;i++){
            allVoteMan.add(new LinkedList<Integer>());
        }
        for(int i=0;i<voteCount;i++){
            int voteFor = sc.nextInt();
            int candyCount = sc.nextInt();
            if(voteFor == 1){
                Num1Couunt ++;
                continue;
            }

            allVoteMan.get(voteFor).add(candyCount);
        }


    }
    public static void  initSort(List<LinkedList<Integer>> list){
        Collections.sort(list, new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
                if(o1.size()>o2.size())
                    return 1;
                else if(o1.size()<o2.size())
                    return -1;
                else
                    return 0;
            }
        });
    }
    public static int findTheLastSame(List<List<Integer>> list){
        int s = 0;
        if(list.size() == 2)
            return 0;

        else{
            for(int i=2;i<list.size();i++){
                if(list.get(i).size() == list.get(2).size())
                    continue;
                else{
                    s = i;
                    break;
                }
            }
            return s;
        }
    }
}
class VoteMan{
    int who;
    int candyCount;
    public VoteMan(int who,int candyCount){
        this.who = who;
        this.candyCount = candyCount;
    }

}