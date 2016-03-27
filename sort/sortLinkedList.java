public ListNode insertionSortList(ListNode head) {
        //null
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        ListNode pre = dummy;
        ListNode post = null;
        while (current != null) {
            post = current.next;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            pre = dummy;
            current = post;
        }
        return dummy.next;
    }
// easy to make mistake
