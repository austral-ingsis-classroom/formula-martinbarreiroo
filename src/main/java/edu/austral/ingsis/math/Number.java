package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;

public class Number implements Function {
  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public double calculate() {
    return value;
  }

  @Override
  public List<String> listVariables() {
    return Collections.emptyList();
  }

  @Override
  public String print() {
    if (value == Math.floor(value)) {
      return String.format("%.0f", value);
    } else {
      return Double.toString(value);
    }
  }
}
