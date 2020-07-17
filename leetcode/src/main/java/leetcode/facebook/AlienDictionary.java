package leetcode.facebook;

/** https://leetcode.com/problems/verifying-an-alien-dictionary/ */
public class AlienDictionary {

  public static void main(String[] args) {
    System.out.println((int) 'a');
  }

  public static boolean isAlienSorted(String[] words, String order) {

    int hash[] = new int[26];

    for (int i = 0; i < order.length(); i++) {
      hash[order.charAt(i) - 97] = i + 1;
    }

    for (int i = 0; i < words.length; i++) {

    }
    return false;
  }
}
