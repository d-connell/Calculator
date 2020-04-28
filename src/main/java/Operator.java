public enum Operator {

    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    interface BinaryOperation {
        double apply(double x, double y);
    }

    static BinaryOperation add = (x, y) -> x + y;
    static BinaryOperation subtract = (x, y) -> x - y;
    static BinaryOperation multiply = (x, y) -> x * y;
    static BinaryOperation divide = (x, y) -> x / y;

}