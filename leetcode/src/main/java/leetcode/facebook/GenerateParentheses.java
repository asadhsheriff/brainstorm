package leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/generate-parentheses/submissions/ */
public class GenerateParentheses {

  public static void main(String[] args) {
    List<String> strings = generateParenthesis(3);
    print(strings);
    strings = generateParenthesis(2);
    print(strings);
  }

  public static void print(List<String> strings) {
    for (int i = 0; i < strings.size(); i++) {
      System.out.println(strings.get(i));
    }
  }

  public static List<String> generateParenthesis(int n) {
    ArrayList<String> finalList = new ArrayList<>();
    recurse(finalList, "", 1, 1, n);
    return finalList;
  }

  public static void recurse(
      List<String> finalList, String operating, int opened, int closed, int n) {
    if (opened > n && closed > n) {
      finalList.add(operating);
      return;
    }
    if (opened <= n) {
      int openedTemp = opened + 1;
      recurse(finalList, operating + "(", openedTemp, closed, n);
    }
    if (closed <= n && closed < opened) {
      int closedTemp = closed + 1;
      recurse(finalList, operating + ")", opened, closedTemp, n);
    }
  }
}
