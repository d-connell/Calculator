import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void shouldPassToConfirmNumbersParsedCorrectly() {
        Controller controller = new Controller();
        assertEquals(-10.35, controller.parseFirstInput("-10.35"));
    }

}