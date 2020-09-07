package leetcode.arrays;

/**
 * https://leetcode.com/problems/rotate-image/submissions/
 */
public class RotateMatrix {

  public static void main(String[] args) {
    //    int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix = {
          {1, 2, 3, 4, 5},
          {6, 7, 8, 9, 10},
          {11, 12, 13, 14, 15},
          {16, 17, 18, 19, 20},
          {21, 22, 23, 24, 25}
        };
    //    int[][] matrix = {{1,2}, {3, 4}};
//    int[][] matrix = {
//      {2, 29, 20, 26, 16, 28},
//      {12, 27, 9, 25, 13, 21},
//      {32, 33, 32, 2, 28, 14},
//      {13, 14, 32, 27, 22, 26},
//      {33, 1, 20, 7, 21, 7},
//      {4, 24, 1, 6, 32, 34}
//    };
    //
    // {{2,29,20,26,16,28},{12,27,9,25,13,21},{32,33,32,2,28,14},{13,14,32,27,22,26},{33,1,20,7,21,7},{4,24,1,6,32,34}}
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + ",");
      }
      System.out.println();
    }

    System.out.println();
    rotate(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ,");
      }
      System.out.println();
    }
  }

  public static void rotate(int[][] matrix) {
    int len = matrix.length;
    if (len == 1) {
      return;
    }
    int[] temp1 = new int[len];
    int[] temp2 = new int[len];
    boolean firstTime = true;

    for (int i = 0; i < len / 2; i++) {
      // right movement
      // copy to temp 1
      for (int tlr = i; tlr < len - i; tlr++) {
        temp1[tlr] = matrix[i][tlr];
      }
      if (!firstTime) {
        int counter = i -1;
        for (int lc = i; lc < len - i; lc++) {
          matrix[i - 1][lc] = temp2[counter++];
        }
      } else {
        firstTime = false;
      }

      // top to down movement
      // copy to temp 2
      // copy from temp 1 to inplacce
      for (int trb = i; trb < len - i; trb++) {
        temp2[trb] = matrix[trb][len - i - 1];
        matrix[trb][len - i - 1] = temp1[trb];
      }

      // right to left movement
      // copy to temp 1
      // copy from temp 2 to inplace
      int counter = i;
      for (int brl = len - i - 1; brl >= i; brl -= 1) {
        temp1[brl] = matrix[len - i - 1][brl];
        matrix[len - i - 1][brl] = temp2[counter++];
      }

      // bottom to top movement
      // copy to temp 2
      // copy from temp 1 to inplace
      counter = i;
      int counter2 = len - i - 2;
      for (int blt = len - i - 2; blt >= i; blt -= 1) {
        temp2[counter++] = matrix[blt][i];
        matrix[blt][i] = temp1[counter2--];
      }
    }

    matrix[len / 2 - 1][len / 2] = temp2[len / 2 - 1];

    //    for (int lc = len/2; lc < len -  ; lc++) {
    //      matrix[i][lc] = temp2[lc];
    //    }
  }
}
