import java.util.Scanner;

public class CalculatorInterface {

    boolean running;

    public CalculatorInterface() {
        running = true;
        MessagePrinter.welcomeMessage();
        interactWithUser();
    }

    private void interactWithUser() {
        while (running) {
            MessagePrinter.simpleInstruction();
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
                MessagePrinter.standardHelpMessage();
                break;
            default:
                operator = Operator.lookForMatchingOperatorLabel(input);
        }
        if (operator == null) {
                MessagePrinter.operationNotRecognised(input);
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
            MessagePrinter.needANumber();
            interactWithUser();
        }
        return input;
    }

}