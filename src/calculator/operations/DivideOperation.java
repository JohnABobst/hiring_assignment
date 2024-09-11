package calculator.operations;

import calculator.interfaces.CalculatorOperation;

public class DivideOperation implements CalculatorOperation {
    @Override
    public Number execute(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}