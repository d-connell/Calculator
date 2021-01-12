import java.awt.*;
import java.util.EnumSet;
import java.util.stream.Collectors;

public enum OperationType {

    ADD("+", Double::sum),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String label;
    private final BinaryOperation binaryOperation;

    interface BinaryOperation {
        double apply(double x, double y);
    }

    OperationType(String label, final BinaryOperation binaryOperation) {
        this.label = label;
        this.binaryOperation = binaryOperation;
    }

    public static void checkLabelsAreUnique() {
        if (!hasUniqueLabels()) {
            throw new IllegalComponentStateException("Operator labels must be unique.");
        }
    }

    private static boolean hasUniqueLabels() {
            return EnumSet.allOf(OperationType.class).stream()
                    .collect(Collectors.groupingBy(operationType -> operationType.label, Collectors.counting()))
                    .values()
                    .stream()
                    .noneMatch(number -> number > 1);
    }

    public static String getLabelsAsString() {
        return EnumSet.allOf(OperationType.class)
                .stream()
                .map(operationType -> operationType.label)
                .collect(Collectors.joining(", "));
    }

    public static OperationType match(String input) {
        return EnumSet.allOf(OperationType.class)
                .stream()
                .filter(operationType -> operationType.label.equals(input))
                .reduce(null, (acc, element) -> element);
    }

    public double apply(double x, double y) {
        return binaryOperation.apply(x, y);
    }

    public String getLabel() {
        return label;
    }

}