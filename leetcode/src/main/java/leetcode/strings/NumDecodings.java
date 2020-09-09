package leetcode.strings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class NumDecodings {

  public static void main(String[] args) {
    System.out.println(numDecodings("100"));
  }

//  public static int numDecodings(String s) {
//    if (s.length() == 1) {
//      if (s.charAt(0) > '0' && s.charAt(0) <= '9') {
//        return 1;
//      } else return 0;
//    }
//    return decode(s, 0, 0);
//  }
//
//  public static int decode(String s, int index, int sofar) {
//    if (index >= s.length() - 1) {
//      return sofar;
//    }
//
//    int togMax = sofar;
//    int ntogMax = sofar;
//    if ((s.charAt(index) == '2' && s.charAt(index + 1) > '0' && s.charAt(index + 1) < '7')
//        || (s.charAt(index) == '1' && s.charAt(index + 1) > '0' && s.charAt(index + 1) <= '9')) {
//      togMax = decode(s, index + 1, sofar + 1);
//    }
//    ntogMax = decode(s, index + 1, sofar);
//
//    if (ntogMax > togMax) {
//      return ntogMax;
//    }
//    return togMax;
//  }

  private static HashMap<Integer, Integer> memo = new HashMap<>();

  public static int recursiveWithMemo(int index, String str) {

    // If you reach the end of the string
    // Return 1 for success.
    if (index == str.length()) {
      return 1;
    }

    // If the string starts with a zero, it can't be decoded
    if (str.charAt(index) == '0') {
      return 0;
    }

    if (index == str.length()-1) {
      return 1;
    }

    // Memoization is needed since we might encounter the same sub-string.
    if (memo.containsKey(index)) {
      return memo.get(index);
    }

    int ans = recursiveWithMemo(index+1, str);
    if (Integer.parseInt(str.substring(index, index+2)) <= 26) {
      ans += recursiveWithMemo(index+2, str);
    }

    // Save for memoization
    memo.put(index, ans);

    return ans;
  }
  public static int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    return recursiveWithMemo(0, s);
  }
}
