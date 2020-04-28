import java.util.Scanner;

public class LambdasCalculator {

    boolean running;

    public LambdasCalculator() {
        MessagePrinter.printInitialMessage();
        running = true;
        interactWithUser();
    }

    private void interactWithUser() {
        while (running) {
            MessagePrinter.printSimpleInstruction();
            Scanner scanner = new Scanner(System.in);
            Operator operator = getOperationType(scanner);
            if (operator != null) {
                double firstNumber = getNumber(scanner);
                double secondNumber = getNumber(scanner);
                calculateAndDisplay(operator, firstNumber, secondNumber);
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
                System.out.println("Requested operator '" + input + "' is not recognised, please try again.");
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
            System.out.println("A number is required.  The program will reset.");
            interactWithUser();
        }
        return input;
    }

    private void calculateAndDisplay(Operator operator, double x, double y) {
        switch (operator) {
            case ADD:
                System.out.println(Operator.add.apply(x, y));
                break;
            case SUBTRACT:
                System.out.println(Operator.subtract.apply(x, y));
                break;
            case MULTIPLY:
                System.out.println(Operator.multiply.apply(x, y));
                break;
            case DIVIDE:
                System.out.println(Operator.divide.apply(x, y));
                break;
        }
    }

}