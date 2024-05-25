package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.List;

public class Variable implements Function {
    private final double value;
    private final String name;

    public Variable(double value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public double calculate() {
        return value;
    }

    @Override
    public List<String> listVariables() {
        return Collections.singletonList(name);
    }

    @Override
    public String print() {
        return name;
    }
}

