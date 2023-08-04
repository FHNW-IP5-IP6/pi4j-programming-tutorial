package view;

import com.pi4j.context.Context;
import controller.Controller;
import model.Model;
import view.components.SimpleButton;

import com.pi4j.catalog.components.base.PIN;

import com.pi4j.mvc.util.mvcbase.PuiBase;

public class View extends PuiBase<Model, Controller> {
    //declare all hardware components attached to Pi
    private SimpleButton button;

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
        //what needs to be done when we shut down the app?
        button.reset();
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        //In the view (GUI and PUI), events triggered by the user are detected.
        //The MVC pattern dictates that the view does modify the model directly
        //but calls a method in the Controller. The Controller updates the model solely.

        //At this point the method --increaseCounter-- from the controller class should be called
        //on the event --Button pressed--.

        button.onDown(controller::increaseCounter);
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        //In the model there is an attribute 'counter'. Every time this variable changes,
        // a message should be displayed on the console that the variable has changed.
        //The console is thus a part of the view and makes the data from the model visible.

        //the following code registers an application specific function on an 'ObservableValue'.
        //This means that every time the value of the observable changes, this function is executed.
        //The function has two parameters oldValue and newValue. In this example these are the values of counter before
        //and after the change
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    System.out.println("You pressed the button " + newValue + " times.");
                });
    }
}
