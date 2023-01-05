package controller;

import model.Model;
import util.mvcbase.ControllerBase;

public class Controller extends ControllerBase<Model> {
    //the app is shut down, when we pressed the button 10 times
    protected final int terminationCount = 10;

    public Controller(Model model) {
        super(model);
    }

    public void pressButton(){
        //whenever the function pressbutton is called, the model will be updated
        //increment counter from model by one
        increase(model.counter);

        //set value ledGlows to true
        setValue(model.ledGlows, true);

        //using 'runLater' assures that new value is set on model
        runLater(m -> {
            if (m.counter.getValue() > terminationCount) {
                terminate();
            }
        });
    }

    public void ledOff(){
        //whenever the function ledOff is called, the model will be updated
        // set value ledGlows to false
        setValue(model.ledGlows, false);
    }

    protected void terminate() {
        System.exit(0);
    }
}
