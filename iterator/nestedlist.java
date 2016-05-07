Stack<NestedInteger> stack = new Stack<NestedInteger>();
    public NestedIterator(List<NestedInteger> nestedList) {
        
        
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger current = stack.peek();
            if (current.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = current.getList().size() - 1; i >= 0; i--) {
                stack.push(current.getList().get(i));
            }
        }
        return false;
    }
    
