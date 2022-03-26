/**
 * Find the kth to last element of a singly linked list. 
 * Return the value of the element.
 *
 * @author Zechen Liu
 * @date 2022/03/26
 **/
public class FindkthToLast {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNode(5);
        System.out.println(kthToLast(listNode, 2));
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
