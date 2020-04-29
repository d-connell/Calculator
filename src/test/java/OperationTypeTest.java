import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTypeTest {

    @Test
    void shouldPassToConfirmStringOfOperatorNamesReturnsAsExpected() {
        // test will fail if the OperationType labels, order or items change
        String expected = "+, -, *, /";
        assertEquals(expected, OperationType.getLabelsAsString());
    }

    @Test
    void shouldPassToConfirmAddOperatorReturnedForInputStringAdd() {
        assertEquals(OperationType.ADD, OperationType.match("+"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForUnrecognisedInput() {
        assertNull(OperationType.match("gibberish"));
    }

    @Test
    void shouldPassToConfirmADDLambdaHasExpectedLogic() {
        assertEquals(10, OperationType.ADD.apply(4, 6));
    }

    @Test
    void shouldPassToConfirmSUBTRACTLambdaHasExpectedLogic() {
        assertEquals(5, OperationType.SUBTRACT.apply(10, 5));
    }

    @Test
    void shouldPassToConfirmMULTIPLYLambdaHasExpectedLogic() {
        assertEquals(10, OperationType.MULTIPLY.apply(2, 5));
    }

    @Test
    void shouldPassToConfirmDIVIDELambdaHasExpectedLogic() {
        assertEquals(2, OperationType.DIVIDE.apply(10, 5));
    }

}