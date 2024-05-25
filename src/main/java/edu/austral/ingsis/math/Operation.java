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
        variables.addAll(rightOperand.listVariables());
        return variables;
    }

    @Override
    public String print() {
        return "(" + leftOperand.print() + " " + operator + " " + rightOperand.print() + ")";
    }
}
