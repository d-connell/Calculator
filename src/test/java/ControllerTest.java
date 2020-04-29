import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void shouldPassToConfirmCorrectOperatorReturnedForInputAdd() {
        Controller controller = new Controller();
        assertEquals(OperationType.ADD, controller.getOperationType("add"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForInputHelp() {
        Controller controller = new Controller();
        assertNull(controller.getOperationType("help"));
    }

    @Test
    void shouldPassToConfirmNullOperatorReturnedForUnrecognisedInput() {
        Controller controller = new Controller();
        assertNull(controller.getOperationType("gibberish"));
    }

}