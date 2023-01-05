package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import util.mvcbase.PuiBase;
import view.components.SimpleButton;
import view.components.SimpleLed;
import view.components.helpers.PIN;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to Pi
    //these are protected to give unit tests access to them
    protected SimpleButton button;
    protected SimpleLed    led;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Which components are we using? use the PIN PWM19 for the new component
        button = new SimpleButton(pi4J, PIN.D26, false);
        led    = new SimpleLed(pi4J, PIN.PWM19);
    }

    @Override
    public void shutdown() {
        //what is there to do when we shut down the app?
        button.deRegisterAll();
        led.off();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //which methods of the controller must be called on a hardware event
        button.onDown(controller::pressButton);
        button.onUp(controller::ledOff);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //which event should be triggered when the model changes
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println("You pressed the button "+newValue+" times.");
                    }
                });

        onChangeOf(model.ledGlows).execute(((oldValue, newValue) -> led.setState(newValue)));
    }
}
