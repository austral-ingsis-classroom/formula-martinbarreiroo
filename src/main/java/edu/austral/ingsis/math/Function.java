package edu.austral.ingsis.math;

import java.util.List;

public interface Function {
  double calculate();

  List<String> listVariables();

  String print();
}
