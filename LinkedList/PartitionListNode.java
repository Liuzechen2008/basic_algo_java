import java.util.List;

/**
 * Partition a linked list, such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x.
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 *
 * @author Zechen Liu
 * @date 2022/03/27
 **/
public class PartitionListNode {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNode(10);
        ListNodeUtil.printListNode(partition(listNode, 5));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode largeList = new ListNode(0);
        ListNode dummySmall = smallList;
        ListNode dummyLarge = largeList;
        while (head != null) {
            if (head.val < x) {
                smallList.next = head;
                smallList = smallList.next;
            } else {
                largeList.next = head;
                largeList = largeList.next;
            }
            head = head.next;
        }
        largeList.next = null;
        smallList.next = dummyLarge.next;
        return dummySmall.next;
    }
}
