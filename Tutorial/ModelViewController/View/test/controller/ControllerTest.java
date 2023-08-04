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
    public void testIncreaseCounter(){
        //given
        Model model = new Model();
        Controller controller = new Controller(model);

        //when
        controller.increaseCounter();
        controller.awaitCompletion();

        //then
        assertEquals(1, model.counter.getValue());

        //when
        controller.increaseCounter();
        controller.awaitCompletion();

        //then
        assertEquals(2, model.counter.getValue());
    }

}