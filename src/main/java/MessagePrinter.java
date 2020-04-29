public class MessagePrinter {

    public static void welcome() {
        System.out.println("Welcome to the calculator program.\n");
        standardHelpMessage();
    }

    public static void standardHelpMessage() {
        System.out.println("To use the calculator, enter the desired operation followed by two numbers.");
        System.out.println("Available operators: " + OperationType.getLabelsAsString());
        System.out.println("\tExample input: 2 * 3.\n");
        System.out.println("Enter exit to terminate the calculator.");
        System.out.println("Enter help to see these instructions again.\n");
    }

    public static void instruction() {
        System.out.println("Please enter your required calculation, separated by spaces, e.g. 2 * 3.");
    }

    public static void firstInputNotRecognised() {
        System.out.println("Please enter either a number, or the 'help' or 'exit' commands as the first input.");
    }

    public static void operationTypeNotRecognised(String input) {
        System.out.println("Requested operator '" + input + "' is not recognised, please try again.");
    }

    public static void requireNumber() {
        System.out.println("A number is required for the third input, please try again.");
    }

    public static void result(double firstNumber, String operationSymbol, double secondNumber, double result) {
        System.out.printf("%f %s %f = %f\n", firstNumber, operationSymbol, secondNumber, result);
    }

}