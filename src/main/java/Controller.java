import java.util.Scanner;

public class Controller {

    boolean isRunning;

    public Controller() {
        isRunning = true;
        OperationType.checkLabelsAreUnique();
        MessagePrinter.welcome();
    }

    public void interact() {
        while (isRunning) {
            MessagePrinter.instruction();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().toLowerCase();
            OperationType operationType = getOperationType(input);
            if (operationType == null) {
                MessagePrinter.operationTypeNotRecognised(input);
            } else {
                double x = getNumber(scanner);
                double y = getNumber(scanner);
                System.out.println(operationType.apply(x, y));
            }
        }
    }

    OperationType getOperationType(String input) {
        OperationType operationType = null;
        switch (input) {
            case "exit":
                terminate();
            case "help":
                MessagePrinter.standardHelpMessage();
                interact();
                break;
            default:
                operationType = OperationType.match(input);
        }
        return operationType;
    }

    private void terminate() {
        System.exit(0);
    }

    private double getNumber(Scanner scanner) {
        double input = 0;
        try {
            input = scanner.nextDouble();
        } catch (Exception e) {
            MessagePrinter.requireNumber();
            interact();
        }
        return input;
    }

}