import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void shouldPassToConfirmStringOfOperatorNamesReturnsAsExpected() {
        // test will fail if the OperationType labels, order or items change
        String expected = "+, -, *, /";
        assertEquals(expected, Operation.getLabelsAsString());
    }

    @Test
    void shouldPassToConfirmAddOperatorReturnedForInputStringAdd() {
        assertEquals(Operation.ADD, Operation.match("+"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForUnrecognisedInput() {
        assertNull(Operation.match("gibberish"));
    }

    @Test
    void shouldPassToConfirmADDLambdaHasExpectedLogic() {
        assertEquals(10, Operation.ADD.apply(4, 6));
    }

    @Test
    void shouldPassToConfirmSUBTRACTLambdaHasExpectedLogic() {
        assertEquals(5, Operation.SUBTRACT.apply(10, 5));
    }

    @Test
    void shouldPassToConfirmMULTIPLYLambdaHasExpectedLogic() {
        assertEquals(10, Operation.MULTIPLY.apply(2, 5));
    }

    @Test
    void shouldPassToConfirmDIVIDELambdaHasExpectedLogic() {
        assertEquals(2, Operation.DIVIDE.apply(10, 5));
    }

}