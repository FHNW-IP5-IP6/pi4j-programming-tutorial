package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import view.components.LedButton;

import com.pi4j.catalog.components.base.PIN;

import com.pi4j.mvc.util.mvcbase.PuiBase;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to Pi
    //these are protected to give unit tests access to them
    protected LedButton ledButton;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Which components are we using? use the PINs D26 and PWM19
        ledButton = new LedButton(pi4J, PIN.D26, false, PIN.PWM19);
    }

    @Override
    public void shutdown() {
        //what is there to do when we shut down the app?
        ledButton.reset();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //which methods of the controller must be called on a hardware event
        ledButton.onDown(controller::activate);
        ledButton.onUp(controller::deactivate);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //How to update the PUI whenever the message changes? Typically, the new message would be displayed in an LCD.
        // To keep this example simple we just print the message to the console
        onChangeOf(model.message)
                .execute((oldValue, newValue) -> System.out.println(newValue));

        onChangeOf(model.active)
                .execute((oldValue, newValue) -> {
                    if (newValue) {
                        ledButton.ledOn();
                    } else {
                        ledButton.ledOff();
                    }
                });
    }
}
