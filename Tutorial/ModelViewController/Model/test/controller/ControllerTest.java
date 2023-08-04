package controller;

import model.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
The whole application logic is implemented in Controller.

We can test it by calling its methods and validate the model status

Because all the model updates are executed asynchronously in a separate thread, we have to wait until these threads have finished
by calling 'awaitTermination'
 */
class ControllerTest {
    @Test
    public void testActivate(){
        //given
        Model model = new Model();
        Controller controller = new Controller(model);

        //when
        controller.activate();
        controller.awaitCompletion();

        //then
        assertEquals(1, model.counter.getValue());
        assertTrue(model.active.getValue());
        assertTrue(model.message.getValue().contains("1 times"));
    }

    @Test
    public void testDeactivate(){
        //given
        Model model = new Model();
        Controller controller = new Controller(model);
        controller.activate();

        //when
        controller.deactivate();
        controller.awaitCompletion();

        //then
        assertEquals(1, model.counter.getValue());
        assertFalse(model.active.getValue());
        assertTrue(model.message.getValue().contains("1 times"));
    }

}