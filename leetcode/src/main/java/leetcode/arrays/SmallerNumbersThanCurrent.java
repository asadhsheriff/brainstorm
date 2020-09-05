package leetcode.arrays;

public class SmallerNumbersThanCurrent {

  public static void main(String[] args) {
    System.out.println("Testing");
    int[] uns = {8, 1, 2, 2, 3};
    int[] results = smallerNumbersThanCurrent(uns);
    for (int i = 0; i < uns.length; i++) {
      System.out.print(results[i] + ", ");
    }
  }

  public static int[] smallerNumbersThanCurrent(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i += 1) {
      int count = 0;
      for (int j = 0; j < nums.length; j += 1) {
        if (j != i && nums[j] < nums[i]) {
          count++;
        }
      }
      result[i] = count;
    }
    return result;
  }
}
