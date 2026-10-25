class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (checkIsland(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean up = checkIsland(grid, i - 1, j);
        boolean down = checkIsland(grid, i + 1, j);
        boolean left = checkIsland(grid, i, j - 1);
        boolean right = checkIsland(grid, i, j + 1);
        return up && down && left && right;
    }
}