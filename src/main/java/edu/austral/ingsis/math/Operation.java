package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class Operation implements Function {
  private final Function leftOperand;
  private final Function rightOperand;
  private final char operator;

  public Operation(Function leftOperand, Function rightOperand, char operator) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.operator = operator;
  }

  @Override
  public double calculate() {
    return switch (operator) {
      case '+' -> leftOperand.calculate() + rightOperand.calculate();
      case '-' -> leftOperand.calculate() - rightOperand.calculate();
      case '*' -> leftOperand.calculate() * rightOperand.calculate();
      case '/' -> leftOperand.calculate() / rightOperand.calculate();
      case '^' -> Math.pow(leftOperand.calculate(), rightOperand.calculate());
      case '|' -> Math.abs(leftOperand.calculate());
      default -> throw new IllegalArgumentException("Invalid operator");
    };
  }

  @Override
  public List<String> listVariables() {
    List<String> variables = new ArrayList<>();
    variables.addAll(leftOperand.listVariables());
    if (rightOperand != null) {
      variables.addAll(rightOperand.listVariables());
    }
    return variables;
  }

  @Override
  public String print() {
    String left =
        (leftOperand instanceof Operation && ((Operation) leftOperand).operator != '|')
            ? "(" + leftOperand.print() + ")"
            : leftOperand.print();
    String right =
        rightOperand != null
            ? (rightOperand instanceof Operation
                ? "(" + rightOperand.print() + ")"
                : rightOperand.print())
            : "";

    if (operator == '|') {
      return "|" + left + "|";
    } else {
      return left + " " + operator + " " + right;
    }
  }
}
