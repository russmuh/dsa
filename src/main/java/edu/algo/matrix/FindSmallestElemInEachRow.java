package edu.algo.matrix;

/**
 * Given a matrix mat with dimensions m x n, where m represents the number of rows and n represents
 * the number of columns. Each row in the matrix is sorted in strictly increasing order. You must
 * find the smallest element that is common to all rows in the matrix. If no such common element
 * exists, return -1.
 *
 * <pre>
 *   input: [[2, 3, 4, 5, 6], [1, 2, 6, 9, 12], [4, 6, 8, 10, 12], [2, 4, 6, 8, 10]]
 *   output: 6
 * </pre>
 */
public class FindSmallestElemInEachRow {

  public static void main(String[] args) {
    final int[][] m = {
      {2, 3, 4, 5, 6},
      {1, 2, 6, 9, 12},
      {4, 6, 8, 10, 12},
      {2, 4, 6, 8, 10}
    };

    System.out.println(FindSmallestElemInEachRow.smallestCommonElement(m));
  }

  /**
   * Overall time complexity is O(m * n), where m represents the number of rows and n represents the
   * number of columns.
   */
  private static int smallestCommonElement(int[][] matrix) {
    // Initialize an array to hold the count of each element
    int[] elementCount = new int[10001];


    // Iterate through each row of the matrix
    for (int[] row : matrix) {
      // Iterate through each element in the row
      for (int element : row) {
        // Increment the count for this element
        elementCount[element]++;

        // If the count for the current element equals the number of rows
        // it means we have found a common element present in all rows
        if (elementCount[element] == matrix.length) {
          // Return the first smallest common element found
          return element;
        }
      }
    }

    // If no common element is found in all rows, return -1
    return -1;
  }

  private static int oldSchoolFindMin(final int[][] m) {
    int min = -1;

    for (int i = 0; i < m[0].length; i++) {
      int row = 1;

      int j = 0;
      while (row < m.length && j < m[0].length) {
        if (m[0][i] == m[row][j]) {
          min = m[0][i];
          row++;
          j = 0;
        } else if (m[0][i] < m[row][j]) {
          min = -1;
          break;
        } else {
          j++;
        }
      }
    }

    return min;
  }
}
