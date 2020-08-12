package linkedlist;

//LeetCode No.203 移除链表元素
public class RemoveLinkedListElement2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 4, 3, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        ListNode node = new RemoveLinkedListElement2().removeElements(listNode, 6);
        System.out.println(listNode);
    }
}
