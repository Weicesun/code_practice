ListNode pre = new ListNode(0);
        ListNode runner = pre;
        ListNode fast = pre;
        pre.next = head;
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int i = 0;
        while (fast.next != null) {
            i++;
            fast = fast.next;
        }
        k = i - k % i;
        while(k > 0) {
            runner = runner.next;
            k--;
        }
        fast.next = head;
        head = runner.next;
        runner.next = null;
            
        return head;
