import java.util.*;

class Solution {
    int rows;
    int cols;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, cols - 1, atlantic, heights);
        }

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
            dfs(rows - 1, c, atlantic, heights);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] heights) {
        visited[row][col] = true;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }

            if (visited[newRow][newCol]) {
                continue;
            }

            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, visited, heights);
        }
    }
}