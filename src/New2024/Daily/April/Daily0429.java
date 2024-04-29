package New2024.Daily.April;
/*
1329. Sort the Matrix Diagonally
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 */

public class Daily0429 {
    /**
     * 解题思路，将对角线元素单独抽看，并进行排序。
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 处理所有对角线，从最左侧列开始
        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col, m, n);
        }

        // 处理所有对角线，从最顶部行开始（除了第一行第一列对角线，因为已经在上面的循环中处理过了）
        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0, m, n);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int startRow, int startCol, int m, int n) {
        int i = startRow;
        int j = startCol;
        int len = Math.min(m - startRow, n - startCol);
        int[] diagonal = new int[len];

        // 提取对角线元素
        for (int k = 0; k < len; k++) {
            diagonal[k] = mat[i + k][j + k];
        }

        // 使用快速排序
        quickSort(diagonal, 0, len - 1);

        // 将排序后的对角线元素放回
        for (int k = 0; k < len; k++) {
            mat[i + k][j + k] = diagonal[k];
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
