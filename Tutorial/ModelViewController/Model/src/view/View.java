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
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them
    protected LedButton ledButton;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Which components are we using?
        ledButton = new LedButton(pi4J, PIN.D26, false, PIN.PWM19);
    }

    @Override
    public void shutdown() {
        //what is there to do when we shut down the app?
        ledButton.btnDeRegisterAll();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //what happens, when we interact with the hardware?
        ledButton.btnOnDown(controller::pressButton);
        ledButton.btnOnUp(controller::ledOff);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //what happens, when the model registered that we interacted with the components?
        onChangeOf(model.message).execute((oldValue, newValue) -> System.out.println(newValue));

        onChangeOf(model.ledGlows).execute(((oldValue, newValue) -> ledButton.ledSetState(newValue)));
    }
}
