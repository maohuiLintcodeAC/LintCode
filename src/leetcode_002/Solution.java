package leetcode_002;

/**
 * 给定两个非空链表来代表两个非负数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (true) {
            result.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null && l2 != null) {
                result.next = new ListNode(0);
                result = result.next;
            } else if (l1 == null && l2 == null) {
                if (carry == 1) {
                    result.next = new ListNode(carry);
                }
                return head;
            } else {
                l1 = l1 == null ? l2 : l1;
                result.next = new ListNode(0);
                result = result.next;
                break;
            }
        }

        if (carry == 1) {
            while (true) {
                result.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                if (l1 != null) {
                    result.next = new ListNode(0);
                    result = result.next;
                } else {
                    if (carry == 1) {
                        result.next = new ListNode(1);
                    }
                    break;
                }
            }
        } else {
            while (true) {
                result.val = l1.val;
                l1 = l1.next;
                if (l1 != null) {
                    result.next = new ListNode(0);
                    result = result.next;
                } else {
                    break;
                }
            }
        }

        return head;
    }
}



