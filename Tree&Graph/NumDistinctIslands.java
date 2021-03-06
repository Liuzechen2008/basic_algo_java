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
                    dfs(grid, i, j, sb,"s");
                    result.add(sb.toString());
                }
            }
        }
        return result.size();
    }

    private static void dfs(int[][] grid, int i, int j, StringBuilder path,String s) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        path.append(s);
        dfs(grid, i + 1, j, path,"d");
        dfs(grid, i - 1, j, path,"u");
        dfs(grid, i, j + 1, path,"r");
        dfs(grid, i, j - 1, path,"l");
        path.append(s);
    }
}
