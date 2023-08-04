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
        increaseValue(model.counter);

        //set the model to 'active'
        setValue(model.active, true);

        //using 'runLater' assures that new value is set on model
        runLater(m -> {
            if (m.counter.getValue() > TERMINATION_COUNT) {
                terminate();
            }
        });
    }

    public void deactivate(){
        //set the model to 'inactive'
        setValue(model.active, false);
    }

    private void terminate() {
        System.exit(0);
    }
}
