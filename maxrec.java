public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int num = 0;
            if (heights.length == i) {
                num = -1;
            } else {
                num = heights[i];
            }
            if (!stack.isEmpty() && heights[stack.peek()] <= num) {
                stack.push(i);
            } else {
                int index = 0;
                while (!stack.isEmpty() && heights[stack.peek()] > num) {
                    index = stack.pop();
                    area = Math.max(area, heights[index]* (i - index));
                    heights[index] = num;
                }
                stack.push(index);
            }
        }
        return area;
