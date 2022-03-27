/**
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * @author Zechen Liu
 * @date 2022/03/27
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtil.initListNode(8);
        ListNode listNode2 = ListNodeUtil.initListNode(7);
        ListNodeUtil.printListNode(addTwoNumbers(listNode1, listNode2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode listNode = new ListNode(0);
        ListNode dummy = listNode;
        while (l1 != null || l2 != null || carry == 1) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if (sum > 9) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            listNode.next = new ListNode(sum);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            listNode = listNode.next;
        }
        return dummy.next;
    }
}
