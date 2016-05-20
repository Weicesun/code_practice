public String serialize(TrieNode root) {
        // Write your code here
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Iterator seril = root.children.entrySet().iterator();
        while(seril.hasNext()) {
            Map.Entry entry = (Map.Entry)seril.next();
            Character key = (Character)entry.getKey();
            TrieNode child = (TrieNode)entry.getValue();
            sb.append(key);
            sb.append(serialize(child));
        }
        sb.append(">");
        return sb.toString();
    }
