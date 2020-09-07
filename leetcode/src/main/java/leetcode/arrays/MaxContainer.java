package leetcode.arrays;

/** https://leetcode.com/problems/container-with-most-water/ */
public class MaxContainer {

  public static void main(String[] args) {
    int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(nums));
  }

  public static void sort(int[] nums, int low, int high) {
    if (low > high) {
      return;
    }

    int partitionIndex = partition(nums, low, high);

    sort(nums, low, partitionIndex - 1);
    sort(nums, partitionIndex + 1, high);
  }

  public static int partition(int[] nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;

    for (int j = low; j < high; j += 1) {
      if (nums[j] < pivot) {
        ++i;
        swap(nums, i, j);
      }
    }

    swap(nums, i + 1, high);
    return i + 1;
  }

  public static void swap(int[] nums, int swapF, int swapT) {
    int temp = nums[swapF];
    nums[swapF] = nums[swapT];
    nums[swapT] = temp;
  }

  public static int maxArea(int[] height) {
    int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) l++;
      else r--;
    }
    return maxarea;
  }
}
