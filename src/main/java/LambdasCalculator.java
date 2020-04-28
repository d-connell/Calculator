import java.util.Scanner;

public class LambdasCalculator {

    boolean running;

    public LambdasCalculator() {
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
            case "add":
                operator = Operator.ADD;
                break;
            case "subtract":
                operator = Operator.SUBTRACT;
                break;
            case "multiply":
                operator = Operator.MULTIPLY;
                break;
            case "divide":
                operator = Operator.DIVIDE;
                break;
            default:
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

}