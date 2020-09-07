package leetcode.strings;

/** https://leetcode.com/problems/robot-return-to-origin/ */
public class RobotMovement {

  public static void main(String[] args) {
    System.out.println(judgeCircle("LL"));
  }

  public static boolean judgeCircle(String moves) {
    int myX = 0, myY = 0;
    for (int i = 0; i < moves.length(); i += 1) {
      switch (moves.charAt(i)) {
        case 'L':
          myX -= 1;
          break;
        case 'R':
          myX += 1;
          break;
        case 'U':
          myY += 1;
          break;
        case 'D':
          myY -= 1;
          break;
      }
    }

    if (myX == 0 && myY == 0) {
      return true;
    }
    return false;
  }
}
