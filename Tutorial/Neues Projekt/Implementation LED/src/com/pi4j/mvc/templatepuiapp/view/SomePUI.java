package com.pi4j.mvc.templatepuiapp.view;

import com.pi4j.catalog.components.SimpleButton;
import com.pi4j.catalog.components.SimpleLED;
import com.pi4j.catalog.components.helpers.PIN;
import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.controller.SomeController;
import com.pi4j.mvc.templatepuiapp.model.SomeModel;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class SomePUI extends PuiBase<SomeModel, SomeController> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them

    // this was created during task "Implementation Button"
    protected SimpleButton button;

    protected SimpleLED led;

    public SomePUI(SomeController controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        // this was created during task "Implementation Button"
        button = new SimpleButton(pi4J, PIN.D26, false);

        led = new SimpleLED(pi4J, PIN.PWM19);
    }

    @Override
    public void setupUiToActionBindings(SomeController controller) {
        //always trigger a Controller action

        // this was created during task "Implementation Button"
        // button.onDown(controller::pressButton);

        button.onDown(controller::ledOn);

        button.onUp(controller::ledOff);
    }

    //this was created during task "Implementation Button", it is no longer necessary for this application
    //    public void setupModelToUiBindings(SomeModel model) {
    //        onChangeOf(model.counter)
    //                .execute((oldValue, newValue) -> {
    //                    System.out.println("Button was pressed" + newValue);
    //                });
    //    }

    public void setupModelToUiBindings(SomeModel model) {
        onChangeOf(model.ledGlows)
                .execute((oldValue, newValue) -> {
                    if (newValue) {
                        led.on();
                    } else {
                        led.off();
                    }
                });
    }

}
