 public int calculate(String s) {
        String s1 = s.trim();
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<String> operQueue = new LinkedList<String>();
        int result = 0;
        String flag1 = "+-*/";
        String flag2 = "*/"
        String temp = new String();
        for (int i = 0; i < s1.length(); i++) {
            if (flag2.contains(s1.charAt(i) + "")) {
                int temp1 = queue.poll();
                int temp2 = 
            }
            if (flag1.contains(s1.charAt(i)+"")) {
                operQueue.offer(s1.charAt(i) + "");
                continue;
            }
            
            
        }
        
    public int nextNumber(int index, String s1){
        String flag = "+-*/";
        int num;
        String temp = new String();
        while (!flag.contains(s1.charAt(i)+"")) {
                temp = temp + s1.charAt(i)+"";
            }
        num = Integer.parseInt(temp);
        return num;
    }
