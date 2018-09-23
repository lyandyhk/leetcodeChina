package September;

import java.util.Scanner;



public class toutiao_920_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int count = 0;
        for(int i=left;i<=right;i++){
            String str = ""  + i;
            if(str.length() == 1){
                count++;
                continue;
            }

            for(int j=0;j<str.length()/2;j++){
                if(str.charAt(j) != str.charAt(str.length()-2-j))
                    continue;
                count++;
            }
        }
        System.out.println(count);

    }
}
