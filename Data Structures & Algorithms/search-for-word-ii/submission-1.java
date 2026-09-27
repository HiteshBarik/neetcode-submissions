class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length, COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        TrieNode root = new TrieNode();
        for(String word: words) {
            root.addWord(word);
        }

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        int ROWS = board.length, COLS = board[0].length;
        if(c < 0 || r < 0 || c >= COLS || r >= ROWS || 
        !node.children.containsKey(board[r][c]) || visit[r][c]) {
            return;
        }

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.isWord) {
            res.add(word);
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}
