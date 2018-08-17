package group1;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 *
 * 解答：按行访问，按数学规律，从一行的某位到下一位，其实是走了对于边长三角形的两条边，再走到下一个又是另一个三角形的两条边，如此循环一行即可输出一行
 * 比如上面例子中第二行
 *
 *
 *
 * A   L          I
 * Y A      与  L S     就是对于行的两个三角形
 * P
 */
public class Problem6 {
    public static String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length() || s.length() == 0)
            return s;
        //计数从1开始，所以在开头加上一个辅助index便于计算位置
        s = "h" + s;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=numRows;i++){
            sb.append(s.charAt(i));
            int k = i;
            while(true){
                //第一个三角形，当边为0会访问两边同一个值，所以需要排除这种情况
                if(numRows - i != 0){
                    k = k + 2 * (numRows - i);
                    if(k > s.length()-1)
                        break;
                    sb.append(s.charAt(k));
                }
                //第二个三角形，当边为0会访问两边同一个值，所以需要排除这种情况
                if(i - 1 != 0){
                    k = k + 2 * (i-1);
                    if(k > s.length()-1)
                        break;
                    sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("134876",2));
    }
}
