package group2;

    import java.util.Scanner;

public class Tencent3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int food = sc.nextInt();
        System.out.println(getResult(day,food));
    }
    public static int getResult(int day,int food){
        int x = food;
        int y = 1;
        for(int i=0;i<day-1;i++){
            x = x * 2;
            y = y * 2;
        }

        y = y * 2 - 1;

        return x/y;
    }
}
