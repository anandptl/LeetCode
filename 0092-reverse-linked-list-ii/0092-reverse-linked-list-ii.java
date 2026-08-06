
class Solution {
     public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        ListNode newHead = reverseList(n);
        n.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right) return head;
        ListNode a =null, b =null, c=null, d =null;
        int pos =1;
        ListNode temp = head;
        while(temp != null){
            if(pos == left-1) a = temp;
            if(pos == left) b = temp;
            if(pos == right) c = temp;
            if(pos == right+1) d = temp;

            temp = temp.next;
            pos++;
        }

        if(a != null) a.next = null; 
        if(c != null) c.next = null;

        reverseList(b);

        if(a != null)a.next = c; 
        b.next = d;

        if(a==null) return c;
        return head;
    }
}