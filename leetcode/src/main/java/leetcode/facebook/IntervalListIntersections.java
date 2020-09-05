package leetcode.facebook;

import java.util.ArrayList;

/** https://leetcode.com/problems/interval-list-intersections/ */
public class IntervalListIntersections {

  public static void main(String[] args) {
    int A[][] = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int B[][] = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
//    [[5,10]]
//[[5,6]]
    int result[][] = intervalIntersection(A, B);

    for (int i = 0; i < result.length ; i++) {
      System.out.println(result[i][0] + ", " + result[i][1]);
    }
  }

  public static int[][] intervalIntersection(int[][] A, int[][] B) {
    int ai = 0;
    int bi = 0;
    ArrayList<int[]> results = new ArrayList<>();
    while (ai < A.length && bi < B.length) {
      if (B[bi][0] <= A[ai][1] && B[bi][0] >= A[ai][0]) {
        results.add(new int[] {B[bi][0], A[ai][1]});
        ai++;
        continue;
      }
      if (A[ai][0] <= B[bi][1] && A[ai][0] >= B[bi][0]) {
        results.add(new int[] {A[ai][0], B[bi][1]});
        bi++;
        continue;
      }

      if (A[ai][1] < B[bi][0]) {
        ai++;
        continue;
      }
      if (B[bi][1] < A[ai][0]) {
        bi++;
        continue;
      }

      //
      //      if (A[ai][1] <= B[bi][0]) { // A's end is overlapping
      //        results.add(new int[] {A[ai][1], B[bi][0]});
      //        bi++;
      //      }
      //      if (A[ai][1] >= B[bi][0]) { // B's end is overlapping
      //        results.add(new int[] {B[bi][0], A[ai][1]});
      //        ai++;
      //      }

    }
    return (int[][]) results.toArray(new int[results.size()][2]);
  }
}
