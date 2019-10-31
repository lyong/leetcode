package xyz.lyong.leetcode.Q1_50;

/**
 * @Author lvyong
 * @Desription
 * @Date 2019-10-31 14:35
 */

public class Q2AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode start = null;
        int carry = 0;
        int bitValue = 0;

        bitValue = l1.val + l2.val;
        carry = bitValue / 10;
        bitValue = bitValue % 10;
        ListNode result = new ListNode(bitValue);
        start = result;
        while (l1.next != null) {
            l1 = l1.next;
            if (l2.next != null) {
                l2 = l2.next;
                bitValue = l1.val + l2.val + carry;
                carry = bitValue / 10;
                bitValue = bitValue % 10;
            } else {
                bitValue = l1.val;
                if (carry != 0) {
                    bitValue = bitValue + carry;
                    carry = bitValue / 10;
                    bitValue = bitValue % 10;
                }
            }

            result.next = new ListNode(bitValue);
            result = result.next;
        }

        if (l2.next != null) {
            while (l2.next != null) {
                l2 = l2.next;
                bitValue = l2.val;
                if (carry != 0) {
                    bitValue = bitValue + carry;
                    carry = bitValue / 10;
                    bitValue = bitValue % 10;
                }
                result.next = new ListNode(bitValue);
                result = result.next;
            }
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return start;
    }
}
