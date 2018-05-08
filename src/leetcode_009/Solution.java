package leetcode_009;

/**
 * Created by lenovo on 2018/5/8.
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int y = 0;
        int z = x;
        int tmp;
        while(z > 0) {
            tmp = z % 10;
            z /= 10;
            y = 10 * y + tmp;
        }

        if (y == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b = new Solution().isPalindrome(-0);
        System.out.println(b);
    }
}
