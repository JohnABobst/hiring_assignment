package calculator;

import calculator.enums.Operation;
import calculator.interfaces.CalculatorOperation;
import calculator.mappers.OperationsMapper;

import java.util.Map;

public class Calculator {
    private final Map<Operation, CalculatorOperation> operations;

    public Calculator() {
        this.operations = OperationsMapper.getInstance().getOperationsMap();
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        CalculatorOperation operation = operations.get(op);
        if (operation == null) {
            throw new UnsupportedOperationException("calculator.enums.Operation not supported.");
        }
        return operation.execute(num1, num2);
    }

    public Number chainOperations(Number initialValue, Operation[] ops, Number[] values) {
        if (ops.length != values.length) {
            throw new IllegalArgumentException("The length of operations and values arrays must be the same.");
        }

        Number result = initialValue;
        for (int i = 0; i < ops.length; i++) {
            result = calculate(ops[i], result, values[i]);
        }
        return result;
    }
}
