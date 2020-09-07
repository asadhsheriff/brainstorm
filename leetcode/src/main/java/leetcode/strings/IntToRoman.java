package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(1994));
  }

  public static String intToRoman(int num) {
    class RomanPair {
      private char roman;

      private Integer value;

      public RomanPair(char roman, Integer value) {
        this.roman = roman;
        this.value = value;
      }

      public char getRoman() {
        return roman;
      }

      public void setRoman(char roman) {
        this.roman = roman;
      }

      public Integer getValue() {
        return value;
      }

      public void setValue(Integer value) {
        this.value = value;
      }
    }
    List<RomanPair> pairs = new ArrayList<>(7);
    pairs.add(new RomanPair('I', 1));
    pairs.add(new RomanPair('V', 5));
    pairs.add(new RomanPair('X', 10));
    pairs.add(new RomanPair('L', 50));
    pairs.add(new RomanPair('C', 100));
    pairs.add(new RomanPair('D', 500));
    pairs.add(new RomanPair('M', 1000));

    StringBuilder converted = new StringBuilder();
    int carryOver = num;
    for (int i = pairs.size() - 1; i >= 0; i -= 2) {
      int div = carryOver / pairs.get(i).getValue();
      carryOver = carryOver % pairs.get(i).getValue();
      if (pairs.get(i).getValue() != 1000) {
        if (div >= 5) {
          if (div == 9) {
            converted.append(pairs.get(i).getRoman());
            converted.append(pairs.get(i + 2).getRoman());
          } else {
            converted.append(pairs.get(i + 1).getRoman());
            for (int j = 5; j < div; j++) {
              converted.append(pairs.get(i).getRoman());
            }
          }
        } else {
          if (div == 4) {
            converted.append(pairs.get(i).getRoman());
            converted.append(pairs.get(i + 1).getRoman());
          } else {
            for (int j = 1; j <= div; j++) {
              converted.append(pairs.get(i).getRoman());
            }
          }
        }
        //        if (div == 9) {
        //          converted += pairs.get(i).getRoman();
        //          converted += pairs.get(i + 2).getRoman();
        //        } else if (div == 4) {
        //          converted += pairs.get(i).getRoman();
        //          converted += pairs.get(i + 1).getRoman();
        //        } else if (div == 5) {
        //          converted += pairs.get(i + 1).getRoman();
        //        } else {
        //          for (int j = 1; j <= div; j++) {
        //            converted += pairs.get(i).getRoman();
        //          }
        //        }
        //      } else {
        //        for (int j = 1; j <= div; j++) {
        //          converted += pairs.get(i).getRoman();
        //        }
        //      }
      } else {
        for (int j = 1; j <= div; j++) {
          converted.append(pairs.get(i).getRoman());
        }
      }
    }
    return converted.toString();
  }
}
