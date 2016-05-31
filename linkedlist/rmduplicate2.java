public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode runner = head;
        while (runner != null) {
            while (runner != null && runner.next != null && runner.val == runner.next.val) {
                while (runner != null && runner.next != null && runner.val == runner.next.val)
                runner = runner.next;
                if (runner != null)
                runner = runner.next;
            }
            pre.next = runner;
            pre = pre.next;
            if (runner != null) {
                runner = runner.next;
            }
        }
        return dummy.next;
