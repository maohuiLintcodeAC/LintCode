package leetcode_003;

/**
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int max = 1;
        int start = 0;
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            // 判断当前字符是否包含在 subString中
            if (subString.contains(String.valueOf(s.charAt(i)))) {
                // 若果是被包含了，则该子串 不再叠加字符
                // 判断当前最大子串长度
                max = max > subString.length() ? max : subString.length();
                // 重置start为出现字符s.charAt(i)的下一个位置
                start += subString.indexOf(s.charAt(i)) + 1;
                subString = s.substring(start, i + 1);
            } else {
                subString += s.charAt(i);
            }
        }
        return max > subString.length() ? max : subString.length();
    }

    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("bbbb");
        System.out.println(result);
    }
}
