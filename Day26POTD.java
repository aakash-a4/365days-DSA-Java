//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = scanner.nextInt(); // Number of rows
            int m = scanner.nextInt(); // Number of columns
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
        scanner.close();
    }
}

// } Driver Code Ends

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int islandCount = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // When a land cell ('1') is found, perform DFS to explore the island
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return islandCount;
    }

    // Helper method to perform DFS
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        // Check if the current position is out of bounds or is water ('0')
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') {
            return;
        }

        // Mark the current land cell as visited by changing it to '0'
        grid[i][j] = '0';

        // Explore all 8 possible directions (up, down, left, right, and diagonals)
        int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int d = 0; d < 8; d++) {
            int newRow = i + dRow[d];
            int newCol = j + dCol[d];
            dfs(grid, newRow, newCol, n, m);
        }
    }
}

