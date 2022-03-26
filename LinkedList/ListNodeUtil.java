import java.util.Random;

/**
 * @author Zechen Liu
 * @date 2022/03/26
 **/
public class ListNodeUtil {
    public static ListNode initListNode() {
        Random r = new Random();
        ListNode dummy = new ListNode(r.nextInt(10));
        ListNode nextNode;
        nextNode = dummy;
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(r.nextInt(10));
            nextNode.next = node;
            nextNode = nextNode.next;
        }
        printListNode(dummy);
        return dummy;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
