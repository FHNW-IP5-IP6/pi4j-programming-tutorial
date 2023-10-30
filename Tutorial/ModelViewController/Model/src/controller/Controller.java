package controller;

import model.Model;

import com.pi4j.mvc.util.mvcbase.ControllerBase;

public class Controller extends ControllerBase<Model> {
    //the app is shut down, when we pressed the button 10 times
    private static final int TERMINATION_COUNT = 10;

    public Controller(Model model) {
        super(model);
    }

    public void activate(){
        //set new message on model
        setValue(model.message, "You pressed the button " + (get(model.counter) + 1) + " times");

        //increment counter from model by one
        increaseValue(model.counter);
        setValue(model.active, true);

        //using 'runLater' assures that new value is set on model
        runLater(m -> {
            if (m.counter.getValue() > TERMINATION_COUNT) {
                terminate();
            }
        });
    }

    public void deactivate(){
        setValue(model.active, false);
    }

    protected void terminate() {
        System.exit(0);
    }
}
