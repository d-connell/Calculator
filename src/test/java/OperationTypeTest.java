import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTypeTest {

    @Test
    void shouldPassToConfirmStringOfOperatorNamesReturnsAsExpected() {
        // test will fail if list of Operators changes (labels, order, additions, removals)
        String expected = "add, subtract, multiply, divide";
        assertEquals(expected, OperationType.getLabelsAsString());
    }

    @Test
    void shouldPassToConfirmAddOperatorReturnedForInputStringAdd() {
        assertEquals(OperationType.ADD, OperationType.match("add"));
    }

    @Test
    void shouldPassToConfirmNullReturnedForInputStringNone() {
        assertNull(OperationType.match("none"));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersAddCorrectly() {
        assertEquals(10, OperationType.ADD.apply(5, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersSubtractCorrectly() {
        assertEquals(5, OperationType.SUBTRACT.apply(10, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersMultiplyCorrectly() {
        assertEquals(10, OperationType.MULTIPLY.apply(2, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersDivideCorrectly() {
        assertEquals(2, OperationType.DIVIDE.apply(10, 5));
    }

}