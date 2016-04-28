Queue<Iterator<Integer>> queue = new LinkedList<Iterator<Integer>>();
    Iterator<Integer> current = null;
    public Vector2D(List<List<Integer>> vec2d) {
        for (int i = 0; i < vec2d.size(); i++) {
            queue.offer(vec2d.get(i).iterator());
        }
        current = queue.poll();
    }

    @Override
    public Integer next() {
        if (!current.hasNext()) {
            return -1;
        }
        return current.next();
    }

    @Override
    public boolean hasNext() {
        if (current == null) {
            return false;
        } 
            
            while (!current.hasNext()) {
                if (!queue.isEmpty()) {
                    current = queue.poll();
                } else {
                    return false;
                }
            }
        return true;
    }
