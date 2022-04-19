import java.util.HashSet;
import java.util.Set;

/**
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * Return the number of distinct islands.
 *
 * @author Zechen Liu
 * @date 2022/04/19
 **/
public class NumDistinctIslands {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
        };
        int[][] grid2 = {
                {0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
        };
        System.out.println(numDistinctIslands(grid1));//3
        System.out.println(numDistinctIslands(grid2));//15
    }

    private static int numDistinctIslands(int[][] grid) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "start:");
                    result.add(sb.toString());
                }
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
        return result.size();
    }

    private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;//visited
        sb.append(dir);
        dfs(grid, i - 1, j, sb, "u"); // up
        dfs(grid, i + 1, j, sb, "d"); // down
        dfs(grid, i, j - 1, sb, "l"); // left
        dfs(grid, i, j + 1, sb, "r"); // right
    }
}
