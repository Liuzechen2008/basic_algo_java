import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * @author Zechen Liu
 * @date 2022/03/26
 **/
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initListNode();
        ListNodeUtil.printListNode(removeDuplicateNodes(listNode));
    }
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){ return head;}
        ListNode dummy = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while(head.next!=null){
            if(!set.add(head.next.val)){
                head.next = head.next.next;
            } else{
                head = head.next;
            }
        }
        return dummy;
    }
}

