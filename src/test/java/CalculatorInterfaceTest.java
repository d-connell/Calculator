import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorInterfaceTest {

    @Test
    void shouldPassToConfirmCorrectOperatorReturnedForInputAdd() {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        assertEquals(Operator.ADD, calculatorInterface.getOperationType("add"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForInputHelp() {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        assertNull(calculatorInterface.getOperationType("help"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForUnrecognisedInput() {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        assertNull(calculatorInterface.getOperationType("gibberish"));
    }

}