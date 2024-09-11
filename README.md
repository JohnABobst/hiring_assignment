I decided to not define any operations within the calculator class itself and instead the calculator relies on a map of operations to do it's calculations. I created an interface so that all operations would have an execute function that takes in two numbers.  I put all of the operations in a package and each class implements the interface. I used a config file to connect the operation enums to their respective classes.  I created a mapper class to dynamically generate the map the calculator uses to perform operations.  Any future operations that are created just need to be added to that config file to be included in the calculator.