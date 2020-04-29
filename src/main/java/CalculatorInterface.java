import java.util.Scanner;

public class CalculatorInterface {

    boolean running;

    public CalculatorInterface() {
        running = true;
        Operator.checkLabelsAreUnique();
        MessagePrinter.welcomeMessage();
    }

    public void interactWithUser() {
        while (running) {
            MessagePrinter.simpleInstruction();
            Scanner scanner = new Scanner(System.in);
            Operator operator = getOperationType(scanner.next().toLowerCase());
            if (operator != null) {
                double x = getNumber(scanner);
                double y = getNumber(scanner);
                System.out.println(operator.apply(x, y));
            }
        }
    }

    Operator getOperationType(String input) {
        Operator operator = null;
        switch (input) {
            case "exit":
                terminate();
            case "help":
                MessagePrinter.standardHelpMessage();
                break;
            default:
                operator = Operator.lookForOperatorWithMatchingLabel(input);
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