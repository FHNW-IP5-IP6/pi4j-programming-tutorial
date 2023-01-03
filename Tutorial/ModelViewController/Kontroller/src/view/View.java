package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import util.mvcbase.PuiBase;
import view.components.SimpleButton;
import view.components.SimpleLed;
import view.components.helpers.PIN;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them
    protected SimpleButton button;
    protected SimpleLed    led;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Which components are we using?
        button = new SimpleButton(pi4J, PIN.D26, false);
        led    = new SimpleLed(pi4J, PIN.PWM19);
    }

    @Override
    public void shutdown() {
        //what is there to do when we shut down the app?
        button.deRegisterAll();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //what happens, when we interact with the hardware?
        button.onDown(controller::pressButton);
        button.onUp(controller::ledOff);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //what happens, when the model registered that we interacted with the components?
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println("You pressed the button "+newValue+" times.");
                    }
                });

        // here, lambdas are used. More information on this: https://www.w3schools.com/java/java_lambda.asp
        // We detect changes on a value of the model with *OnChangeOf*, and with execute we want to call
        // a function. Now this function we want to call, is not yet declared. So we do this on the same line.
        // So we can call something like "() -> functionWeWantToUse()".
        // While the first parentheses includes the parameters, the second one will use the variabel and call
        // our new function.
        onChangeOf(model.ledGlows).execute(((oldValue, newValue) -> led.setState(newValue)));
    }
}
