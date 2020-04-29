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
            String secondInput = scanner.next();
            OperationType operationType = OperationType.match(secondInput);
            if (operationType == null) {
                MessagePrinter.operationTypeNotRecognised(secondInput);
            } else {
                double secondNumber = getNumber(scanner);
                double result = operationType.apply(firstNumber, secondNumber);
                MessagePrinter.result(firstNumber, operationType.getLabel(), secondNumber, result);
            }
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
                firstInput = getFirstNumber(input);
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

    private double getFirstNumber(String input) {
        double firstNumber = 0;
        try {
            firstNumber = Double.parseDouble(input);
        } catch (NumberFormatException exception) {
            MessagePrinter.firstInputNotRecognised();
            interact();
        }
        return firstNumber;
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