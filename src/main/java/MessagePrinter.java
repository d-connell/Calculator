public class MessagePrinter {

    public static void printInitialMessage() {
        System.out.println("Welcome to the calculator program.\n");
        System.out.println("To use the calculator, enter the desired operation followed by two numbers.");
        System.out.println("Available operators: add, subtract, divide, multiply.");
        System.out.println("\tExample input: add 2 2.\n");
        System.out.println("Enter exit to terminate the Basic Calculator.");
        System.out.println("Enter help to see these instructions again.\n");
    }

    public static void printSimpleInstruction() {
        System.out.println("Please enter the desired operation, followed by two numbers.");
    }

    public static void printHelp() {
        System.out.println("To use the calculator, please enter the desired operation, followed by two numbers.");
        System.out.println("Available operators: add, subtract, divide, multiply.");
        System.out.println("\tExample input: add 2 2.");
        System.out.println("Enter exit to terminate the Basic Calculator.");
        System.out.println("Enter help to see these instructions again.\n");
    }

    public static void printNeedANumber() {
        System.out.println("A number is required, please try again.");
    }

    public static void printOperationNotRecognised(String input) {
        System.out.println("Requested operator '" + input + "' is not recognised, please try again.");
    }

}