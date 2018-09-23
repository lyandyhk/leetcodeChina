package September;

import java.util.*;


public class toutiao_920_4 {
    public static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(m+n<k-1 || m+k<n-1 || k+n<m-1){
            System.out.println(0);
            return;
        }

    }
}
