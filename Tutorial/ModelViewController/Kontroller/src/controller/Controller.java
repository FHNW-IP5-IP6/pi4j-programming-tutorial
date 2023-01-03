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
        //whenever the button is pressed, the model is updated
        increase(model.counter);

        //what happens when we press the button? we set a new value to the model
        setValue(model.ledGlows, true);

        //using 'runLater' assures that new value is set on model
        runLater(m -> {
            if (m.counter.getValue() > terminationCount) {
                terminate();
            }
        });
    }

    public void ledOff(){
        //what happens, when we lift the button? we set a new value to the model
        setValue(model.ledGlows, false);
    }

    protected void terminate() {
        System.exit(0);
    }
}
