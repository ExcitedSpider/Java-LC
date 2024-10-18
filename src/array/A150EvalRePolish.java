package array;

import java.util.Set;

public class A150EvalRePolish {
  int index;

  public int evalRPN(String[] tokens) {
    if (tokens.length == 0)
      return 0;

    index = tokens.length - 1;
    return evalRPN0(tokens);
  }

  public int evalRPN0(String[] tokens) {
    if (index < 0) {
      throw new RuntimeException("Unfinished expression");
    }

    if (isOp(tokens[index])) {
      var op = tokens[index];
      index--;

      var rightOprand = evalRPN0(tokens);
      var leftOprand = evalRPN0(tokens);
      return semOp(op, leftOprand, rightOprand);
    } else {
      var res = Integer.parseInt(tokens[index]);
      index--;
      return res;
    }
  }

  // semantics of operator
  private int semOp(String op, int leftOprand, int rightOprand) {
    if (op == "+") {
      return leftOprand + rightOprand;
    } else if (op == "-") {
      return leftOprand - rightOprand;
    } else if (op == "*") {
      return leftOprand * rightOprand;
    } else if (op == "/") {
      return leftOprand / rightOprand;
    } else {
      throw new RuntimeException("Undefined operator " + op);
    }
  }

  static Set<String> operators = Set.of("+", "-", "*", "/");

  private boolean isOp(String string) {
    return operators.contains(string);
  }
}
