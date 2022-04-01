import java.util.*;
import java.io.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *Use the string parameter of your exception to indicate what happened.
  *Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
// eval("11 3 - 4 + 2.5 *") is 30.0
// eval("10 2.0 +") is 12.0
// eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
// eval("1 2 3 4 5 + * - -") is 26.0
  public static double eval(String s){
    boolean has = false;
    ArrayDeque<Double> nums = new ArrayDeque<Double>();
    Scanner in = new Scanner(s);
    while (in.hasNext()){
      if (in.hasNextDouble()){
        has = true;
        nums.addFirst(in.nextDouble());
      }else{
        if (nums.size() <= 1){
          throw new IllegalArgumentException("too few operands for operation" + in.next());
        }
        double n = nums.removeFirst();
        String i = in.next();
        if (i.equals("+")){
          nums.addFirst(nums.removeFirst() + n);
        }
        if (i.equals("-")){
          nums.addFirst(nums.removeFirst() - n);
        }
        if (i.equals("*")){
          nums.addFirst(nums.removeFirst() * n);
        }
        if (i.equals("/")){
          nums.addFirst(nums.removeFirst() / n);
        }
        if (i.equals("%")){
          nums.addFirst(nums.removeFirst() % n);
        }
      }
    }if (!has){
      throw new IllegalArgumentException("too few operands");
    }
    if (nums.size() > 1){
      throw new IllegalArgumentException("too many operands");
    }else{
      return nums.getFirst();
    }
  }

  public static void main (String[] args){
    System.out.println(eval("4 5 7 2 + - *"));
    System.out.println(eval("3 4 + 2 * 7 /"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
    // eval("11 3 - 4 + 2.5 *") is 30.0
    // eval("10 2.0 +") is 12.0
    // eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
    // eval("1 2 3 4 5 + * - -") is 26.0
  }

}
