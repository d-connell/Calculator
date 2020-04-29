import java.util.Scanner;

public class Controller {

    boolean isRunning;

    public Controller() {
        OperationType.checkLabelsAreUnique();
        MessagePrinter.welcome();
        isRunning = true;
    }

    public void interact() {
        while (isRunning) {
            MessagePrinter.instruction();
            Scanner scanner = new Scanner(System.in);
            double firstNumber = parseFirstInput(scanner.next());
            OperationType operationType = parseSecondInput(scanner.next());
            double secondNumber = parseNumber(scanner.next(), false);
            double result = operationType.apply(firstNumber, secondNumber);
            MessagePrinter.result(firstNumber, operationType.getLabel(), secondNumber, result);
        }
    }

    double parseFirstInput(String input) {
        double firstInput;
        switch (input.toLowerCase()) {
            case "exit":
                terminate();
            case "help":
                processHelpRequest();
            default:
                firstInput = parseNumber(input, true);
        }
        return firstInput;
    }

    private void terminate() {
        System.exit(0);
    }

    private void processHelpRequest() {
        MessagePrinter.standardHelpMessage();
        interact();
    }

    private double parseNumber(String input, boolean isFirstInput) {
        double number = 0;
        try {
            number = Double.parseDouble(input);
        } catch (Exception e) {
            if (isFirstInput) {
                MessagePrinter.firstInputNotRecognised();
            } else {
                MessagePrinter.requireNumber();
            }
            interact();
        }
        return number;
    }

    private OperationType parseSecondInput(String input) {
        OperationType operationType = OperationType.match(input);
        if (operationType == null) {
            MessagePrinter.operationTypeNotRecognised(input);
            interact();
        }
        return operationType;
    }

}