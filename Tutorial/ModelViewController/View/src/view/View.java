package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import util.mvcbase.PuiBase;
import view.pui.components.SimpleButton;
import view.pui.components.helpers.PIN;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them
    protected SimpleButton button;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //Which components are we using?
        button = new SimpleButton(pi4J, PIN.D26, false);
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
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //what happens, when the modle registered that we interacted with the components?
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    if (newValue != null) {
                        System.out.println("You pressed the button "+newValue+" times.");
                    }
                });
    }
}
