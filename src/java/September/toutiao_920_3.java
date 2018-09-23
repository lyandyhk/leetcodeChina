package September;

import java.util.*;


public class toutiao_920_3 {
    public static Set<String> set = new HashSet<>();
    public static String[] words;
    public static String[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        matrix = new String[m][n];
        sc.nextLine();
        String wordStr = sc.nextLine();

        words = wordStr.split(" ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.next();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int[][] flags = new int[m][n];
                String curr = matrix[i][j];
                step(flags,i,j,"");
            }
        }
        for(String s : set){
            System.out.println(s);
        }
    }
    public static void step(int[][] martix,int i,int j,String curr){
        if(i<0 || i>=martix.length || j<0 || j>=martix[0].length)
            return;
        if(martix[i][j] == -1)
            return;
        curr = curr + matrix[i][j];
        for(String s : words){
            if(s.startsWith(curr)){
                if(s.length() == curr.length())
                    set.add(curr);
                else{
                    int[][] newMartix = Arrays.copyOf(martix,martix.length);
                    newMartix[i][j] = -1;
                    step(newMartix,i-1,j,curr);
                    step(newMartix,i,j-1,curr);
                    step(newMartix,i+1,j,curr);
                    step(newMartix,i,j+1,curr);
                }
            }
            else{
                continue;
            }
        }
    }
}
