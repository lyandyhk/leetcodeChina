package September;

import com.sun.javafx.binding.SelectBinding;

import java.util.Scanner;



public class toutiao_920_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] regional = new String[n];
        String[] least = new String[n];
        for(int i=0;i<n;i++){
            regional[i] = sc.next();
            least[i] = "";
        }
        for(int i=0;i<n-1;i++){
            int resultLength = 1;
            int alsoNeed = 0;
            for(int k=1;k<regional[i].length();k++){
                boolean canNext = false;
                String start = regional[i].substring(0,k);
                for(int j=i+1;j<n;j++){
                    if(regional[j].startsWith(start)){
                        canNext = true;
                        alsoNeed = j;
                        break;
                    }

                }
                if(canNext)
                    continue;
                else{
                    resultLength = k;
                    break;
                }

            }
            if(least[i].length() < resultLength){
                least[i] = regional[i].substring(0,resultLength);
            }
            if(least[alsoNeed].length() < resultLength){
                least[alsoNeed] = regional[alsoNeed].substring(0,resultLength);
            }
        }
        for(String s : least){
            System.out.println(s);
        }
    }
}

class Str {
    public int id;
    public String regional;
    public String least;
    public Str(int id,String regional,String least){
        this.id = id;
        this.regional = regional;
        this.least = least;
    }
}