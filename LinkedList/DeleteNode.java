/**
 * Delete a node in the middle of a singly linked list, given only access to that node.
 *
 * @author Zechen Liu
 * @date 2022/03/26
 **/
public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNode(5);
        deleteNode(ListNodeUtil.getNode(listNode, 3));
        ListNodeUtil.printListNode(listNode);
    }

    public static void deleteNode(ListNode node) {
        //copy the data from the next node over to the current node and delete the next node.
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
