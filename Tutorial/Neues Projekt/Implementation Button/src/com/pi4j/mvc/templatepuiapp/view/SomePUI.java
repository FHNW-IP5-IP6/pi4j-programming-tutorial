package com.pi4j.mvc.templatepuiapp.view;

import com.pi4j.catalog.components.SimpleButton;
import com.pi4j.catalog.components.helpers.PIN;
import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.controller.SomeController;
import com.pi4j.mvc.templatepuiapp.model.SomeModel;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class SomePUI extends PuiBase<SomeModel, SomeController> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them

    // TODO: create object button from simpleButton
    protected SimpleButton button;

    public SomePUI(SomeController controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        // TODO: init button with PIN.D26
        button = new SimpleButton(pi4J, PIN.D26, false);
    }

    @Override
    public void setupUiToActionBindings(SomeController controller) {
        // TODO: call pressButton form controller if button is pressed
        //always trigger a Controller action
        button.onDown(controller::pressButton);
    }

    public void setupModelToUiBindings(SomeModel model) {
        onChangeOf(model.counter)
                .execute((oldValue, newValue) -> {
                    System.out.println("Button was pressed" + newValue);
                });
    }

}
