package calculator.mappers;

import calculator.enums.Operation;
import calculator.interfaces.CalculatorOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OperationsMapper {

    private static OperationsMapper instance;

    // OperationsMapper is a singleton to save on resources
    public static synchronized OperationsMapper getInstance() {
        if (instance == null) {
            instance = new OperationsMapper();
        }
        return instance;
    }

    // This method reads the configuration file and returns the operations map needed by the calculator. I don't store
    // it as a variable so that it always gets the latest operations
    public Map<Operation, CalculatorOperation> getOperationsMap() {
        Map<Operation, CalculatorOperation> operationsMap = new HashMap<>();

        try {
            // Load the operations.config file
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/calculator/config/operations.config"); // Path to operations.config file
            properties.load(fis);

            // Loop through the properties and load classes dynamically
            for (String key : properties.stringPropertyNames()) {
                String className = properties.getProperty(key);

                // Dynamically load the class
                Class<?> clazz = Class.forName(className);
                if (CalculatorOperation.class.isAssignableFrom(clazz)) {
                    // Instantiate the class using reflection
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    CalculatorOperation operation = (CalculatorOperation) constructor.newInstance();

                    // Map the operation to the enum
                    Operation operationEnum = Operation.valueOf(key);
                    operationsMap.put(operationEnum, operation);
                }
            }

        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        // Return the calculator.Calculator instance with injected calculator.operations
        return operationsMap;
    }
}

