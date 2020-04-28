import java.util.EnumSet;
import java.util.Scanner;

public class CalculatorInterface {

    boolean running;

    public CalculatorInterface() {
        running = true;
        MessagePrinter.printInitialMessage();
        interactWithUser();
    }

    private void interactWithUser() {
        while (running) {
            MessagePrinter.printSimpleInstruction();
            Scanner scanner = new Scanner(System.in);
            Operator operator = getOperationType(scanner);
            if (operator != null) {
                double x = getNumber(scanner);
                double y = getNumber(scanner);
                System.out.println(operator.apply(x, y));
            }
        }
    }

    private Operator getOperationType(Scanner scanner) {
        Operator operator = null;
        String input = scanner.next().toLowerCase();
        switch (input) {
            case "exit":
                terminate();
            case "help":
                MessagePrinter.printHelp();
                break;
            default:
                operator = checkOperatorLabels(input);
        }
        if (operator == null) {
                MessagePrinter.printOperationNotRecognised(input);
        }
        return operator;
    }

    private void terminate() {
        System.exit(0);
    }

    private double getNumber(Scanner scanner) {
        double input = 0;
        try {
            input = scanner.nextDouble();
        } catch (Exception e) {
            MessagePrinter.printNeedANumber();
            interactWithUser();
        }
        return input;
    }

    private Operator checkOperatorLabels(String input) {
        return EnumSet.allOf(Operator.class)
                .stream()
                .filter(operator -> operator.getLabel().equals(input))
                .reduce(null, (acc, element) -> element);
    }

}