package view;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import org.junit.jupiter.api.Test;
import view.components.SimpleButton;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {
    Context pi4j = Pi4J.newAutoContext();
    Controller controller = new Controller(new Model());
    View view = new View(controller, pi4j);

    @Test
    public void testButtonType() {
        assertTrue(view.button instanceof SimpleButton);
    }

    @Test
    public void testButtonMethod() {
        Runnable runnable = () -> controller.pressButton();
        assertSame(view.button.getOnDown(), runnable);
    }
}
