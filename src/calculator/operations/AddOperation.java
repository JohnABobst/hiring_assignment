package calculator.operations;

import calculator.interfaces.CalculatorOperation;

public class AddOperation implements CalculatorOperation {
    @Override
    public Number execute(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}


// MultiplyOperation class


// DivideOperation class
