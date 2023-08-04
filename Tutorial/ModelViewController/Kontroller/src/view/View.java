package view;

import com.pi4j.context.Context;

import controller.Controller;
import model.Model;
import view.components.SimpleButton;
import view.components.SimpleLed;

import com.pi4j.catalog.components.base.PIN;

import com.pi4j.mvc.util.mvcbase.PuiBase;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to Pi
    private SimpleButton button;
    private SimpleLed led;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Initialize all Components that we declared before; use pin PWM19 for the new component
        button = new SimpleButton(pi4J, PIN.D26, false);
        led = new SimpleLed(pi4J, PIN.PWM19);
    }

    @Override
    public void shutdown() {
        //what needs to be done when we shut down the app?
        button.reset();
        led.reset();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //which methods of the controller must be called on a hardware event
        button.onDown(controller::activate);
        button.onUp(controller::deactivate);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //which event should be triggered when the model changes
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println("You pressed the button " + newValue + " times.");
                    }
                });

        // here, lambdas are used. More information on this: https://www.w3schools.com/java/java_lambda.asp
        // We detect changes on a value of the model with 'OnChangeOf', and within 'execute' we do all the necessary
        // updates of the PUI.
        // So we can call something like "() -> functionWeWantToBeExecuted()"
        onChangeOf(model.active)
                .execute((oldValue, newValue) -> {
                    if (newValue) {
                        led.on();
                    } else {
                        led.off();
                    }
                });
    }
}
