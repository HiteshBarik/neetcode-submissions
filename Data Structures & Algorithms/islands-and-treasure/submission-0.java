class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ROWS = grid.length, COLS = grid[0].length;
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    q.add(new int[] {r, c});
                }
            }
        }
        if(q.size() == 0) return;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(r >= ROWS || c >= COLS || r < 0 || c < 0
                || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] {r, c});

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
