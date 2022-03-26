import java.util.Random;

/**
 * @author Zechen Liu
 * @date 2022/03/26
 **/
public class ListNodeUtil {
    public static ListNode initListNode(int length) {
        Random r = new Random();
        ListNode dummy = new ListNode(r.nextInt(length));
        ListNode nextNode;
        nextNode = dummy;
        for (int i = 1; i < length; i++) {
            ListNode node = new ListNode(r.nextInt(length));
            nextNode.next = node;
            nextNode = nextNode.next;
        }
        printListNode(dummy);
        return dummy;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode getNode(ListNode listNode, int index) {
        for (int i = 1; i < index; i++) {
            listNode = listNode.next;
        }
        return listNode;
    }
}
