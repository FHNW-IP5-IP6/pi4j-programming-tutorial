package com.pi4j.mvc.simonsaysapp.view.pui;

import com.pi4j.catalog.components.LedButton;
import com.pi4j.context.Context;

import com.pi4j.catalog.components.base.PIN;

import com.pi4j.mvc.simonsaysapp.controller.Controller;
import com.pi4j.mvc.simonsaysapp.model.Model;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class PUI extends PuiBase<Model, Controller> {
    /* Possible Solution:
       Using 4 LEDButtons in an Array, each having its own index and giving this index to the controller,
       which checks if it's the right index of the LED.
    */

    /**
     * The input method of SimonSays. an Array of 4 LEDButtons.
     */
    protected LedButton[] ledButtons;

    /**
     * Create a new PUI
     *
     * @param controller the controller
     * @param pi4J the context
     */
    public PUI(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    /**
     * initialize the Hardware. register them in pi4j.
     */
    @Override
    public void initializeParts() {
        // initialize the array
        this.ledButtons = new LedButton[4];

        // initialize each button for it own. So the PINs are declarable
        ledButtons[0] = new LedButton(pi4J, PIN.D26,   false, PIN.D21);
        ledButtons[1] = new LedButton(pi4J, PIN.PWM19, false, PIN.D20);
        ledButtons[2] = new LedButton(pi4J, PIN.PWM13, false, PIN.D16);
        ledButtons[3] = new LedButton(pi4J, PIN.D6,    false, PIN.PWM12);

    }

    /**
     * function to deregister everything before shutting down.
     */
    @Override
    public void shutdown() {
        for (var ledButton:ledButtons) {
            ledButton.reset();
            ledButton.ledOff();
        }
        super.shutdown();
    }

    /**
     * binding the functions of the PUI to the controller.
     *
     * @param controller the controller
     */
    @Override
    public void setupUiToActionBindings(Controller controller) {
        ledButtons[0].onDown(() -> controller.buttonPressed(0));
        ledButtons[1].onDown(() -> controller.buttonPressed(1));
        ledButtons[2].onDown(() -> controller.buttonPressed(2));
        ledButtons[3].onDown(() -> controller.buttonPressed(3));

        ledButtons[0].onUp(() -> controller.switchOff(0));
        ledButtons[1].onUp(() -> controller.switchOff(1));
        ledButtons[2].onUp(() -> controller.switchOff(2));
        ledButtons[3].onUp(() -> controller.switchOff(3));
    }

    /**
     * listening to the changes of the model.
     *
     * @param model the model
     */
    @Override
    public void setupModelToUiBindings(Model model) {
        onChangeOf(model.ledsGlowing).execute(((oldValue, newValue) -> {
            for (int i = 0; i < ledButtons.length; i++) {
                if(newValue[i]){
                    ledButtons[i].ledOn();
                }
                else {
                    ledButtons[i].ledOff();
                }
            }
        }));

        onChangeOf(model.message).execute(((oldValue, newValue) -> System.out.println(newValue)));
    }
}
