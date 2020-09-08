package leetcode.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
public class LongestPalindrome {

  public static void main(String[] args) {
    System.out.println(longestPalindrome("101"));
  }

  public static boolean checkPalin(String s, int start, int end) {

    int i = start + 1;
    int j = end - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i += 1;
      j -= 1;
    }
    return true;
  }

  public static String longestPalindrome(String s) {
    String palin = "";

    int i = 0;
    int mover = s.length() - 1;
    while (i < s.length() && s.length() - i > palin.length()) {
      // while (mover >= i && palin.length() < mover - i) {

      // }
      if (s.charAt(i) == s.charAt(mover)) {
        if (checkPalin(s, i, mover)) {
          String newPalin = s.substring(i, mover + 1);
          if (palin.length() < newPalin.length()) {
            palin = newPalin;
          }
        }
      }
      if (mover - i > palin.length()) {
        mover -= 1;
      } else {
        i++;
        mover = s.length() - 1;
      }
    }
    return palin;
  }
}
