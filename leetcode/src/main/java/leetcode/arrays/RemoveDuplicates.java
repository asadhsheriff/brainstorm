package leetcode.arrays;

public class RemoveDuplicates {
  public static void main(String[] args) {
    int [] nums = {1, 1, 2};
    System.out.println(removeDuplicates(nums));
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ", ");
    }
  }

  public static int removeDuplicates(int[] nums) {
    int i = 1;
    int oai = 0;
    while (i < nums.length) {
      if (nums[oai] != nums[i]) {
        nums[++oai] = nums[i];
      }
      i++;
    }
    return oai + 1;
  }
}
