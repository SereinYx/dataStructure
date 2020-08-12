package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int [] arr){
        if (arr.length == 0){
            throw new IllegalArgumentException("arr can not be empty.");
        }
        val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}