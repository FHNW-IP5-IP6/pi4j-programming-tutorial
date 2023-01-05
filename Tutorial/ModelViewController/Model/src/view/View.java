package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import util.mvcbase.PuiBase;
import view.components.LedButton;
import view.components.SimpleButton;
import view.components.SimpleLed;
import view.components.helpers.PIN;

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
        ledButton.btnDeRegisterAll();
        ledButton.ledOff();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //which methods of the controller must be called on a hardware event
        ledButton.btnOnDown(controller::pressButton);
        ledButton.btnOnUp(controller::ledOff);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //which event should be triggered when the model changes
        onChangeOf(model.message).execute((oldValue, newValue) -> System.out.println(newValue));

        onChangeOf(model.ledGlows).execute(((oldValue, newValue) -> ledButton.ledSetState(newValue)));
    }
}
