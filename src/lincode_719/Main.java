package lincode_719;

/**
 * 给一个字符串类型的数字, 写一个方法去找到最大值, 你可以在任意两个数字间加 + 或 *
 *
 * 样例
 * 给出 str = 01231, 返回 10 ((((0 + 1) + 2) * 3) + 1) = 10 我们得到了最大值 10
 * 给出 str = 891, 返回 73 因为 8 * 9 * 1 = 72 和 8 * 9 + 1 = 73, 所以73是最大值
 */

public class Main {
    public int calcMaxValue(String str) {

        if (str == null) return 0;
        if(!str.matches("^[0-9]*$")) return 0;
        if (str.length() == 1) return Integer.valueOf(str);

        int max = 0;
        // 0为+号 1 为*号
        int operator = 0;

        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.valueOf(String.valueOf(str.charAt(i)));
            if (tmp <= 1 || max <= 1) {
                operator = 0;
                max += tmp;
            } else {
                max *= tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.print(m.calcMaxValue("01231"));
    }
}
