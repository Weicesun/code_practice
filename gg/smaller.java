//count smaller after self
//5 2 2 6 1
 class Node {
            public int dup = 1, sum = 1;
            int val;
            Node left = null;
            Node right = null;
            public Node(int v, int s) {
                val = v;
                sum = s;
            }
        }
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Node root = null;
        int len = nums.length;
        Integer[] array = new Integer[len];
        for (int i = len - 1; i >= 0; i--) {
            root = insert(root, nums, i, array, 0);
        }
        res = Arrays.asList(array);
        return res;
    }
    public Node insert(Node root, int[] nums, int i, Integer[] array, int presum) {
        if (root == null) {
            root = new Node(nums[i], 0);
            array[i] = presum;
        }
        else if (root.val == nums[i]) {
            root.dup++;
            array[i] = presum + root.sum;
        } else if (root.val > nums[i]) {
             root.sum++;
            root.left = insert(root.left, nums, i, array, presum );
        } else {
            
            root.right = insert(root.right, nums, i, array, presum + root.dup + root.sum);
        }
        return root;
    }
