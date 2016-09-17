import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<String, TopicNode> _map;
    private static Trie _trie;
    private static TopicNode _topics;

    public static class TopicNode {
        String data;
        HashSet<TopicNode> parents = new HashSet<>();
        HashSet<TopicNode> children= new HashSet<>();

        public TopicNode(String rootData) {
            this.data = rootData;
        }

        public void addParent(TopicNode p) {
            parents.add(p);
        }

        public void addChild(TopicNode child) {
            children.add(child);
            Iterator<TopicNode> iterator = child.children.iterator();
            while (iterator.hasNext()) {
                children.add(iterator.next());
            }

            helper(this, child);
        }

        public void helper(TopicNode parent, TopicNode child) {
            child.addParent(parent);
            Iterator<TopicNode> iterator = child.children.iterator();
            while (iterator.hasNext()) {
                helper(parent, iterator.next());
            }
        }

    }

    public static void makeTree(String flat) {
        LinkedList<String> flatArray = new LinkedList<>(Arrays.asList(flat.split(" ")));
        if (flatArray.size() >= 1) {
            _topics = makeTreeHelper(flatArray);
        }
    }

    private static TopicNode makeTreeHelper(LinkedList<String> arraySoFar) {
        TopicNode treeRoot = new TopicNode(arraySoFar.remove());

        // collect children
        if (arraySoFar.get(0).equals("(")) {
            arraySoFar.remove();
            while (!arraySoFar.get(0).equals(")")) {
                treeRoot.addChild(makeTreeHelper(arraySoFar));
            }
            arraySoFar.remove();
        }

        _map.put(treeRoot.data, treeRoot);
        return treeRoot;
    }


    private static class TrieNode {
        char val;
        HashMap<Character, TrieNode> set = new HashMap<>();
        HashMap<String, Integer> topics = new HashMap<>();

        public TrieNode() {

        }
        public TrieNode(char v) {
            this.val = v;
        }

        public void addTopic(String topic) {
            TopicNode t = _map.get(topic);
            Iterator<TopicNode> parentsIter = t.parents.iterator();
            while (parentsIter.hasNext()) {
                TopicNode p = parentsIter.next();
                incrementTopic(p.data);
            }
            incrementTopic(topic);
        }

        public void incrementTopic(String topic) {
            if (topics.containsKey(topic)) {
                int count = topics.get(topic);
                topics.put(topic, count+1);
            } else {
                topics.put(topic, 1);
            }
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // inserts the word and associates each character with given topic
        public void insertWord(String topic, String word) {
            TrieNode pointer = root;

            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);

                if(pointer.set.containsKey(c)){
                    pointer = pointer.set.get(c);
                } else {
                    TrieNode t = new TrieNode(c);
                    pointer.set.put(c, t);
                    pointer = t;
                }
                pointer.addTopic(topic);
            }
        }

        public Integer numAssociations(String topic, String text) {
            TrieNode found = searchNode(text);
            if(found == null || found.topics.get(topic) == null) {
                return 0;
            } else {
                return found.topics.get(topic);
            }
        }

       
        public TrieNode searchNode(String text){
            TrieNode pointer = root;

            for(int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                pointer = pointer.set.get(c);

                if (pointer == null) {
                    return pointer;
                }
            }
            return pointer;
        }
    }

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        _map = new HashMap<>();
        makeTree(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        _trie = new Trie();
        while (m > 0) {
            String[] topicQuestion = sc.nextLine().split(": ");
            _trie.insertWord(topicQuestion[0], topicQuestion[1]);
            m--;
        }
        int k = Integer.parseInt(sc.nextLine());
        while (k > 0) {
            String[] topicQuery = sc.nextLine().split(" ", 2);
            System.out.println(_trie.numAssociations(topicQuery[0], topicQuery[1]));
            k--;
        }
    }
}

