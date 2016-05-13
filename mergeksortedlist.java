O(n^2):
  ListNode pre = new ListNode(0);
        ListNode runner = pre;
        if (lists == null || lists.length == 0) {
            return pre.next;
        }
        while(true) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                  continue;
                } else {
                    if (min > lists[i].val) {
                        index = i;
                        min = lists[i].val;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                break;
            }
            runner.next = new ListNode(min);
            runner = runner.next;
            //if ()
            lists[index] = lists[index].next;
        }
        return pre.next;
priority queue:

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
          return null;
      }
      PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, 
      new Comparator<ListNode>() {
          public int compare(ListNode l1, ListNode l2) {
              if (l1.val < l2.val) {
                  return -1;
              } else if (l1.val == l2.val) {
                  return 0;
              } else {
                  return 1;
              }
          }
      });
      ListNode pre = new ListNode(0);
      ListNode runner = pre;
      for (ListNode node : lists) {
          if (node != null)
          pq.offer(node);
      }
      while (!pq.isEmpty()) {
          runner.next = pq.poll();
          runner = runner.next;
          if (runner.next != null)
          pq.offer(runner.next);
      }
      return pre.next;

merge sort:
    public ListNode mergerTwoSortedList(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode runner = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                runner.next = l2;
                return pre.next;
            }
            else if (l2 == null) {
                runner.next = l1;
                return pre.next;
            }
            else if (l1.val <= l2.val) {
                runner.next = l1;
                runner = runner.next;
                l1 = l1.next;
            }
            else if (l1.val > l2.val) {
                runner.next = l2;
                runner = runner.next;
                l2 = l2.next;
            }
        }
        return pre.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergerTwoSortedList(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        return mergerTwoSortedList(mergeKLists(Arrays.copyOfRange(lists, 0, mid)), mergeKLists(Arrays.copyOfRange(lists, mid, lists.length)));
    }
