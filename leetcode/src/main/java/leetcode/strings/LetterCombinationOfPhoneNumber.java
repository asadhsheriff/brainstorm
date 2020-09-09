package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/ */
public class LetterCombinationOfPhoneNumber {

  public static void main(String[] args) {
    Solution a = new Solution();
    List<String> as = a.letterCombinations("23");
    for (int i = 0; i < as.size(); i++) {
      System.out.print(as.get(i) + ", ");
    }
  }
}

class Solution {
  HashMap<Character, String> keypad = new HashMap<>(8);

  public Solution() {
    keypad.put('2', "abc");
    keypad.put('3', "def");
    keypad.put('4', "ghi");
    keypad.put('5', "jkl");
    keypad.put('6', "mno");
    keypad.put('7', "pqrs");
    keypad.put('8', "tuv");
    keypad.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.equals("")) {
      return new ArrayList<>(0);
    }

    if (!keypad.containsKey(digits.charAt(0))) {
      return new ArrayList<>(0);
    }
    List<String> toBegin = new ArrayList<>(keypad.get(digits.charAt(0)).length());
    for (int i = 0; i < keypad.get(digits.charAt(0)).length(); i += 1) {
      toBegin.add(String.valueOf(keypad.get(digits.charAt(0)).charAt(i)));
    }

    return recursiveExtraction(digits, toBegin, 1);
  }

  public List<String> recursiveExtraction(String digits, List<String> sofar, int index) {
    if (index == digits.length()) {
      return sofar;
    }

    ArrayList<String> toPass =
        new ArrayList<>(sofar.size() * keypad.get(digits.charAt(index)).length());
    for (int i = 0; i < sofar.size(); i++) {
      // TODO add check
      String cartiKeypad = keypad.get(digits.charAt(index));
      for (int j = 0; j < cartiKeypad.length(); j++) {
        toPass.add(sofar.get(i) + cartiKeypad.charAt(j));
      }
    }
    sofar = new ArrayList<>(0);
    return recursiveExtraction(digits, toPass, index + 1);
  }
}
