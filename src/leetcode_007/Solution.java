package leetcode_007;

/**
 * Created by lenovo on 2018/5/4.
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Solution {
    public int reverse(int x) {
        int result;

        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        if (x < 0) {
            s = s.substring(1);
            sb.append("-");
        }
        boolean start = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!start && s.charAt(i) != 0) {
                start = true;
            }
            if (!start) continue;
            sb.append(s.charAt(i));
        }
        try {
            result = Integer.valueOf(sb.toString());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new Solution().reverse(123456789);
        System.out.println(result);
    }
}
