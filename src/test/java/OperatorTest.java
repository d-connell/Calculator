import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void shouldPassToConfirmStringOfOperatorNamesReturnsAsExpected() {
        // test will fail if list of Operators changes (labels, order, additions, removals)
        String expected = "add, subtract, multiply, divide";
        assertEquals(expected, Operator.getLabelsAsString());
    }

    @Test
    void shouldPassToConfirmAddOperatorReturnedForInputStringAdd() {
        assertEquals(Operator.ADD, Operator.lookForOperatorWithMatchingLabel("add"));
    }

    @Test
    void shouldPassToConfirmNullReturnedForInputStringNone() {
        assertNull(Operator.lookForOperatorWithMatchingLabel("none"));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersAddCorrectly() {
        assertEquals(10, Operator.ADD.apply(5, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersSubtractCorrectly() {
        assertEquals(5, Operator.SUBTRACT.apply(10, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersMultiplyCorrectly() {
        assertEquals(10, Operator.MULTIPLY.apply(2, 5));
    }

    @Test
    void shouldPassToConfirmTwoPositiveNumbersDivideCorrectly() {
        assertEquals(2, Operator.DIVIDE.apply(10, 5));
    }

}