package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import util.mvcbase.PuiBase;
import view.components.SimpleButton;
import view.components.helpers.PIN;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to Pi
    //these are protected to give unit tests access to them
    protected SimpleButton button;

    public View(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        //all components have to be initialized here
        //use PIN D26 to initialize your component
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
        //In the view, events are detected by the GUI or PUI and thus the model is updated.
        //The MVC pattern dictates that the view does not write directly to the model
        //but calls a method in the controller that updates the model.

        //At this point the methode --pressButton-- from the controller class should be called
        //on the event --Button pressed--.

        button.onDown(controller::pressButton);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //In the model there is a variable counter. Every time this variable changes,
        // a message should be displayed on the console that the variable has changed.
        //The console is thus a part of the view and makes the data from the model visible.

        //the following syntax registers an application specific function on an observable object.
        //This means that every time the value of the observable changes, this function is executed in a new thread.
        //The function has two parameters oldValue and newValue. In this example these are the values of counter before
        //and after the change
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    System.out.println("You pressed the button "+newValue+" times.");
                });
    }
}
