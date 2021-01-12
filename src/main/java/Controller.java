import java.util.Scanner;

public class Controller {

    boolean isRunning;

    public Controller() {
        Operation.checkLabelsAreUnique();
        MessagePrinter.welcome();
        isRunning = true;
    }

    public void interact() {
        while (isRunning) {
            MessagePrinter.instruction();
            Scanner scanner = new Scanner(System.in);
            double firstNumber = parseFirstInput(scanner.next());
            Operation operation = parseSecondInput(scanner.next());
            double secondNumber = parseNumber(scanner.next(), false);
            double result = operation.apply(firstNumber, secondNumber);
            MessagePrinter.result(firstNumber, operation.getLabel(), secondNumber, result);
        }
    }

    double parseFirstInput(String input) {
        double firstInput;
        switch (input.toLowerCase()) {
            case "exit":
                terminate();
            case "help":
                help();
            default:
                firstInput = parseNumber(input, true);
        }
        return firstInput;
    }

    private void terminate() {
        System.exit(0);
    }

    private void help() {
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

    private Operation parseSecondInput(String input) {
        Operation operation = Operation.match(input);
        if (operation == null) {
            MessagePrinter.operationTypeNotRecognised(input);
            interact();
        }
        return operation;
    }

}