public enum Operator {

    ADD ("add", Double::sum),
    SUBTRACT ("subtract", (x, y) -> x - y),
    MULTIPLY ("multiply", (x, y) -> x * y),
    DIVIDE ("divide", (x, y) -> x / y),
    EXPONENTIAL ("exponential", (x, y) -> Math.pow(x, y));

    private final String label;
    private final BinaryOperation binaryOperation;

    interface BinaryOperation {
        double apply(double x, double y);
    }

    Operator(String label, final BinaryOperation binaryOperation) {
        this.label = label;
        this.binaryOperation = binaryOperation;
    }

    public double apply(double x, double y) {
        return binaryOperation.apply(x, y);
    }

    public String getLabel() {
        return label;
    }
}