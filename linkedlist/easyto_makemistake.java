public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = null;
        //pre.next = head;
        while (head != null) {
            ListNode temp = pre;
            ListNode thead = head.next;
            
            while (temp.next != null && temp.next.val < head.val) {
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;
            head = thead;
        }
        return pre.next;
    }
