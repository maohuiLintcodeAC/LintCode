package leetcode_011;

/**
 * Created by lenovo on 2018/5/8.
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 注意：你不能倾斜容器，n 至少是2。
 */
public class Solution {
    public int maxArea(int[] height) {
        // 结果是：(i2 - i1) * min(a1, 12)
        int result = 0;
        int h, tmp;

        // 记录[i, n]中以i为起点时，面积最大的j点位置
        int currentJ = 0;
        int currentI = 0;

        for (int i = 0; i < height.length; i++) {
            int jj = i + 1;

            // 如果当前位置比之前定位的i要 矮  即可跳过
            if (height[i] < height[currentI]) continue;
            // 如果当前位置比之前定位的 结束点要矮，即可跳过
            else if (height[i] < height[currentJ] && i < currentJ) {
                jj = currentJ;
            }
            for (int j = jj; j < height.length; j++) {
                h = height[j] > height[i] ? height[i] : height[j];
                tmp = (j - i) * h;
                if (result < tmp) {
                    result = tmp;
                    currentJ = j;
                    currentI = i;
                }
            }
        }

        return result;
    }
}
