package leetcode_014;

/**
 * Created by lenovo on 2018/5/9.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuffer result = new StringBuffer();
        for (int i = 0; ; i++) {
            for (int j = 0; j < strs.length; j++) {
                // 无论是否为公共字符，默认先将strs[0]的i位置字符加入result
                if (j == 0) {
                    if (strs[j].length() > i) {
                        result.append(strs[j].charAt(i));
                    } else {
                        return result.toString();
                    }
                } else {
                    // 当strs[]所有的子串在i位置上的值跟0的相同时，进入下一次循环
                    if (strs[j].length() > i && strs[j].charAt(i) == result.charAt(i)) {
                        continue;
                    } else {
                        // 否则删除最后一次添加的字符，并返回
                        result.deleteCharAt(i);
                        return result.toString();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String result = new Solution().longestCommonPrefix(new String[] {"d"});

        System.out.println(result);
    }
}
