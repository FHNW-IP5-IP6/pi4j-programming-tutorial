package controller;

import model.Model;
import util.mvcbase.ControllerBase;

public class Controller extends ControllerBase<Model> {

    protected final int terminationCount = 10;

    public Controller(Model model) {
        super(model);
    }

    public void pressButton(){
        increase(model.counter);

        //using 'runLater' assures that new value is set on model
        runLater(m -> {
            if (m.counter.getValue() > terminationCount) {
                terminate();
            }
        });
    }

    protected void terminate() {
        System.exit(0);
    }
}
