package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

  public static void main(String[] args) {
    //
    int matrix[][] = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    final List<Integer> ordered = spiralOrder(matrix);
    ordered.forEach(item -> System.out.println(item));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int min = Math.min(m, n);
    List<Integer> spiral = new ArrayList<>();
    for (int i = 0; i < min / 2; i += 1) {
      // right
      int ir = 0, id = 0, il = 0;
      for (ir = i; ir < n - i; ir += 1) {
        spiral.add(matrix[i][ir]);
      }
      // down
      for (id = i + 1; id < m - i; id += 1) {
        spiral.add(matrix[id][ir - 1]);
      }
      // left
      for (il = ir - 1; id >= i; id -= 1) {
        spiral.add(matrix[id - 1][il]);
      }
      // up
      for (int iu = id - 1; iu >= i; iu -= 1) {
        spiral.add(matrix[iu][i]);
      }
    }

    return spiral;
  }
}
