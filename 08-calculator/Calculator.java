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
    Deque<Double> operands = new ArrayDeque<Double>();
    ArrayList<Character> operators = new ArrayList<Character>();
    for (int i = s.length() - 1; i > 0; i--){
      String num = "";
      char c = s.charAt(i);
      if (c == '+' || c == '-' || c == '/' || c == '*' || c == '%'){
        operators.add(c);
      }else if (c == ' '){
        i--;
      }else{
        while (s.charAt(i) != ' '){
          num+= s.charAt(i);
          i--;
        }operands.addFirst(Double.parseDouble(num));
      }
    }
    if (operators.size() < operands.size() - 1){
      throw new IllegalArgumentException("too many operands");
    }
    if (operators.size() >= operands.size()){
      throw new IllegalArgumentException("too few operands for operation" + operators.get(0));
    }
  }

  public static double operation(double num1, double num2, )
}
