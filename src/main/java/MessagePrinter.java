public class MessagePrinter {

    public static void welcomeMessage() {
        System.out.println("Welcome to the calculator program.\n");
        standardHelpMessage();
    }

    public static void standardHelpMessage() {
        System.out.println("To use the calculator, enter the desired operation followed by two numbers.");
        System.out.println("Available operators: " + Operator.getLabelsAsString());
        System.out.println("\tExample input: add 2 2.\n");
        System.out.println("Enter exit to terminate the calculator.");
        System.out.println("Enter help to see these instructions again.\n");
    }

    public static void simpleInstruction() {
        System.out.println("Please enter the desired operation, followed by two numbers.");
    }

    public static void needANumber() {
        System.out.println("A number is required, please try again.");
    }

    public static void operationNotRecognised(String input) {
        System.out.println("Requested operator '" + input + "' is not recognised, please try again.");
    }

}