package view;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import org.junit.jupiter.api.Test;
import view.components.SimpleButton;
import view.components.SimpleLed;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    Context pi4j = Pi4J.newAutoContext();
    Controller controller = new Controller(new Model());
    View view = new View(controller, pi4j);

    @Test
    public void testButtonType() {
        assertTrue(view.button instanceof SimpleButton);
    }

    @Test
    public void testLEDType() {
        assertTrue(view.led instanceof SimpleLed);
    }

    @Test
    public void testButtonMethods() {
        Runnable runbtn = () -> controller.pressButton();
        assertSame(view.button.getOnDown(), runbtn);

        Runnable runled = () -> controller.ledOff();
        assertSame(view.button.getOnUp(), runled);
    }
}
