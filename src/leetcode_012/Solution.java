package leetcode_012;

/**
 * Created by lenovo on 2018/5/8.
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution {
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();

        String k = intdiv(num, 1000);
        num %= 1000;
        String h = intdiv(num, 100);
        num %= 100;
        String t = intdiv(num, 10);
        num %= 10;
        String n = intdiv(num, 1);

        return result.append(k)
                .append(h)
                .append(t)
                .append(n)
                .toString();
    }

    public String intdiv(int dividend, int divisor) {
        int result = dividend / divisor;
        StringBuffer sb = new StringBuffer();

        switch (divisor) {
            case 1000:
                while (result > 0) {
                    result--;
                    sb.append("M");
                }
                break;
            case 100:
                handleStr(sb, result, "CM", "D","CD", "C");
                break;
            case 10:
                handleStr(sb, result, "XC", "L", "XL", "X");
                break;
            case 1:
                handleStr(sb, result, "IX",  "V","IV", "I");
                break;
        }
        return sb.toString();
    }

    private void handleStr(StringBuffer sb, int param, String s9, String s5, String s4, String s0) {
        if (param == 9) {
            sb.append(s9);
        } else if (param == 4) {
            sb.append(s4);
        } else if (param > 4 && param < 9){
            param -= 5;
            sb.append(s5);
            while (param > 0) {
                param--;
                sb.append(s0);
            }
        } else {
            while (param > 0) {
                param--;
                sb.append(s0);
            }
        }
    }

    public static void main(String[] args) {
        String result = new Solution().intToRoman(1999);
        System.out.println(result);
    }
}
