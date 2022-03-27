/**
 * check if a linked list is a palindrome.
 *
 * @author Zechen Liu
 * @date 2022/03/27
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNode(3);
        System.out.println(isPalindrome(listNode));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rev = reverseList(slow);
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }
}
