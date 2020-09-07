package leetcode.strings;

/** https://leetcode.com/problems/longest-common-prefix/submissions/ */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"flower", "flow", "flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    int commonIndex = 0;

    boolean breakIt = false;
    for (int i = 0; i < strs[0].length(); i++) {
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() == i || strs[0].charAt(i) != strs[j].charAt(i)) {
          breakIt = true;
          break;
        }
      }
      if (breakIt) {
        break;
      }
      commonIndex++;
    }
    return strs[0].substring(0, commonIndex);
  }
}
