public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     class TrieNode {
         TrieNode[] list = new TrieNode[26];
         String word;
     }
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        if (words == null || words.size() == 0) {
            return res;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, TrieNode root, int i, int j, ArrayList<String> res) {
        char c = board[i][j];
        if (c == '#' || root.list[c - 'a'] == null) {
            return;
        }
        root = root.list[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, root, i - 1, j, res);
        }
        if (j > 0) {
            dfs(board, root, i, j - 1, res);
        }
        if (i < board.length - 1) {
            dfs(board, root, i + 1, j, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, root, i, j + 1, res);
        }
        board[i][j] = c;
    }
    public TrieNode buildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.list[c - 'a'] == null) {
                    p.list[c - 'a'] = new TrieNode();
                    
                }
                p = p.list[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }
}
