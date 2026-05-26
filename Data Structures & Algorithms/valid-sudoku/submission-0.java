class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char val = board[row][col];

                if(val == '.') {
                    continue;
                }

                if(rows[row].contains(val)) {
                    return false;
                }
                rows[row].add(val);

                if(cols[col].contains(val)) {
                    return false;
                }
                cols[col].add(val);

                int boxIndex = row/3 * 3 + col/3;
                if(boxes[boxIndex].contains(val)) {
                    return false;
                }
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}
