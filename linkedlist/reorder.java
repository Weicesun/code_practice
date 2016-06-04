public class Solution {
    public void reorderList(ListNode head) {
         
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        // set2
        ListNode list2 = reverse(slow);
        merge(head, list2);
        
    }
    public ListNode reverse(ListNode mid) {
        ListNode ln = null;
        while (mid != null) {
            ListNode temp = mid.next;
            mid.next = ln;
            ln = mid;
            mid = temp;
        }
        return ln;
    }
    public void merge(ListNode l1, ListNode l2) {
       
        while (l1 != null && l2 != null) {
            ListNode temp2 = l2.next;
            ListNode temp1 = l1.next;
            l1.next = l2;
            if (temp1 != null)
            l2.next = temp1;
            l2 = temp2;
            l1 = temp1;
        }
        if (l1 == null) {
            l1 = l2;
        }
    }
}
