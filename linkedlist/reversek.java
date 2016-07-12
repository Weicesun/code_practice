public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (true) {
            ListNode test = head;
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if (test == null) {
                    flag = true;
                    break;
                }
                test = test.next;
                //pre = pre.next;
            }
            if (flag) {
                break;
            }
            reverseK(pre, head, k);
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
    public void reverseK(ListNode pre, ListNode head, int k) {
        ListNode runner = head;
        for (int i = 0; i < k; i++) {
            if (runner == null) {
                return;
            }
            runner = runner.next;
        }
        
        //ListNode nhead = new ListNode(0);
        ListNode nnode = runner;
        while (head != runner) {
            ListNode temp = head.next;
            head.next = nnode;
            nnode = head;
            head = temp;
        }
        pre.next = nnode;
    } 
