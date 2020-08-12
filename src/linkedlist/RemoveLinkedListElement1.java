package linkedlist;

//LeetCode No.203 移除链表元素
public class RemoveLinkedListElement1 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 4, 3, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        ListNode node = new RemoveLinkedListElement1().removeElements(listNode, 6);
        System.out.println(listNode);
    }
}
