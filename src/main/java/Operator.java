public enum Operator {

    ADD (Double::sum),
    SUBTRACT ((x, y) -> x - y),
    MULTIPLY ((x, y) -> x * y),
    DIVIDE ((x, y) -> x / y);

    private final BinaryOperation binaryOperation;

    interface BinaryOperation {
        double apply(double x, double y);
    }

    Operator(final BinaryOperation binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

    public double apply(double x, double y) {
        return binaryOperation.apply(x, y);
    }

}