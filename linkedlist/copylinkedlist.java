public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return copy(head, map);
    }
    public RandomListNode copy(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        } else {
            RandomListNode temp = new RandomListNode(head.label);
            map.put(head, temp);
            temp.next = copy(head.next, map);
            temp.random = copy(head.random, map);
            return temp;
        }
        
    }
