package tests;

import calculator.Calculator;
import calculator.enums.Operation;

public class CalculatorTest {

    public static void main(String[] args) {
        testAddition();
        testSubtraction();
        testMultiplication();
        testDivision();
        testDivisionByZero();
        testUnsupportedOperation();
        testIllegalEnumArgument();
        testLargeNumbers();
        testChainedOperations();
    }

    private static void testAddition() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.ADD, 5, 3);
        assertEquals(8, result, "Addition Test");
    }

    private static void testSubtraction() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.SUBTRACT, 10, 3);
        assertEquals(7, result, "Subtraction Test");
    }

    private static void testMultiplication() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 7, 6);
        assertEquals(42, result, "Multiplication Test");
    }

    private static void testDivision() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.DIVIDE, 10, 2);
        assertEquals(5, result, "Division Test");
    }

    private static void testDivisionByZero() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Operation.DIVIDE, 10, 0);
            System.out.println("Division by zero test failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Division by zero test passed");
        }
    }

    private static void testUnsupportedOperation() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Operation.valueOf("TEST"), 10, 3);
            System.out.println("Unsupported operation test failed");
        } catch (UnsupportedOperationException e) {
            System.out.println("Unsupported operation test passed");
        }
    }

    private static void testIllegalEnumArgument() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(Operation.valueOf("MODULO"), 10, 3);
            System.out.println("Enum Illegal Argument test failed");
        } catch (IllegalArgumentException e) {
            System.out.println("Enum Illegal Argument test passed");
        }
    }

    private static void testLargeNumbers() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 1e10, 1e10);
        assertEquals(1e20, result, "Large Numbers Test");
    }

    public static void testChainedOperations() {
        Calculator calculator = new Calculator();
        // Define the sequence of operations
        Operation[] ops = {Operation.ADD, Operation.MULTIPLY, Operation.SUBTRACT};
        Number[] values = {3, 2, 1};  // Corresponding values for each operation

        // Start with an initial value
        Number initialValue = 5;

        // Chain the operations: (5 + 3) * 2 - 1
        Number result = calculator.chainOperations(initialValue, ops, values);
        assertEquals(13, result, "Chained operations test failed");
    }

    // Custom assertion method for simplicity
    private static void assertEquals(Number expected, Number actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed: expected " + expected + " but got " + actual);
        }
    }
}

