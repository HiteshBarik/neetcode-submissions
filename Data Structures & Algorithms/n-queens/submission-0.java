class Solution {
    //See normal soln without set

    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board) {

        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++) {
            if(col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board);

            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';
        }
    }
}
