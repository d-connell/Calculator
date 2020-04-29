import java.awt.*;
import java.util.EnumSet;
import java.util.stream.Collectors;

public enum Operator {

    ADD("add", Double::sum),
    SUBTRACT("subtract", (x, y) -> x - y),
    MULTIPLY("multiply", (x, y) -> x * y),
    DIVIDE("divide", (x, y) -> x / y);

    private final String label;
    private final BinaryOperation binaryOperation;

    interface BinaryOperation {
        double apply(double x, double y);
    }

    Operator(String label, final BinaryOperation binaryOperation) {
        this.label = label;
        this.binaryOperation = binaryOperation;
    }

    public static void checkLabelsAreUnique() {
        if (!labelsAreUnique()) {
            throw new IllegalComponentStateException("Operator labels must be unique.");
        }
    }

    private static boolean labelsAreUnique() {
        for (Operator firstOperator : EnumSet.allOf(Operator.class)) {
            for (Operator secondOperator : EnumSet.allOf(Operator.class)) {
                if (firstOperator != secondOperator
                        && firstOperator.label.equals(secondOperator.label)) {
                    return false;
                }
            }
        }
        return true;
    }

    public double apply(double x, double y) {
        return binaryOperation.apply(x, y);
    }

    public static String getLabelsAsString() {
        return EnumSet.allOf(Operator.class)
                .stream()
                .map(operator -> operator.label)
                .collect(Collectors.joining(", "));
    }

    public static Operator lookForOperatorWithMatchingLabel(String input) {
        return EnumSet.allOf(Operator.class)
                .stream()
                .filter(operator -> operator.label.equals(input))
                .reduce(null, (acc, element) -> element);
    }

}