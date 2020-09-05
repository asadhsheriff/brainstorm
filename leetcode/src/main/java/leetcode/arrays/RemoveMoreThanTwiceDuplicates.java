package leetcode.arrays;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/
 */
public class RemoveMoreThanTwiceDuplicates {

  public static void main(String[] args) {
    int[] nums = {1,1,1,1,2,2,3};
    int len = removeDuplicates(nums);
    for (int i = 0; i < len; i++) {
      System.out.print(nums[i] + ", ");
    }
  }

  public static int removeDuplicates(int[] nums) {
    int i = 1;
    int oai = 0;
    boolean isDuplicate = false;
    while (i < nums.length) {
      if (nums[oai] != nums[i]) {
        isDuplicate = false;
        nums[++oai] = nums[i];
      } else {
        if (!isDuplicate) {
          isDuplicate = true;
          nums[++oai] = nums[i];
        }
      }
      i++;
    }
    if (isDuplicate) {
      nums[oai] = nums[i-1];
    }
    return oai + 1;
  }
}
