/**
 * Given an M x N matrix in which each row and each column is sorted in ascending order, write a method to find an element.
 * @author Zechen Liu
 * @date 2022/04/12
 **/
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] ns1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        System.out.println(searchMatrix(ns1, 20));
        System.out.println(searchMatrix(ns1, 5));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int len = matrix.length;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < len && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
