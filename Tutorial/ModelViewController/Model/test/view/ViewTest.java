package view;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import org.junit.jupiter.api.Test;
import util.mvcbase.ObservableValue;
import view.components.LedButton;
import view.components.SimpleButton;
import view.components.SimpleLed;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    Context pi4j = Pi4J.newAutoContext();
    Controller controller = new Controller(new Model());
    View view = new View(controller, pi4j);

    @Test
    public void testLedButtonType() {
        assertTrue(view.ledButton instanceof LedButton);
    }

    @Test
    public void testButtonMethods() {
        Runnable runbtn = () -> controller.pressButton();
        assertSame(view.ledButton.btnGetOnDown(), runbtn);

        Runnable runled = () -> controller.ledOff();
        assertSame(view.ledButton.btnGetOnUp(), runled);
    }

    @Test
    public void testModel(){
        var model = new Model();

        assertTrue(model.counter instanceof ObservableValue<Integer>);
        assertTrue(model.ledGlows instanceof ObservableValue<Boolean>);
        assertTrue(model.message instanceof ObservableValue<String>);
    }
}
