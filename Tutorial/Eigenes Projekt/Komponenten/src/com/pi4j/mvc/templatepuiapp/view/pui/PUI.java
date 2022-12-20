package com.pi4j.mvc.templatepuiapp.view.pui;

import com.pi4j.catalog.components.LedButton;
import com.pi4j.catalog.components.helpers.PIN;
import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.controller.Controller;
import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class PUI extends PuiBase<Model, Controller> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them
    protected LedButton[] ledButtons;

    public PUI(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {
        ledButtons[0] = new LedButton(pi4J, PIN.D26, false, PIN.D21);
        ledButtons[1] = new LedButton(pi4J, PIN.PWM19, false, PIN.D20);
        ledButtons[2] = new LedButton(pi4J, PIN.PWM13, false, PIN.D16);
        ledButtons[3] = new LedButton(pi4J, PIN.D6, false, PIN.PWM12);
    }

    @Override
    public void shutdown() {
        for (var ledButton:ledButtons) {
            ledButton.btnDeRegisterAll();
        }
        super.shutdown();
    }

    @Override
    public void setupUiToActionBindings(Controller controller) {
        ledButtons[0].btnOnDown(() -> controller.checkSeries(0));
        ledButtons[1].btnOnDown(() -> controller.checkSeries(1));
        ledButtons[2].btnOnDown(() -> controller.checkSeries(2));
        ledButtons[3].btnOnDown(() -> controller.checkSeries(3));
    }

    @Override
    public void setupModelToUiBindings(Model model) {
        onChangeOf(model.glowingLED).execute(((oldValue, newValue) -> {
            if(newValue >= 4){
                for (var ledbutton : ledButtons) {
                    ledbutton.ledOff();
                }
            }else{
                ledButtons[newValue].ledOn();
            }
        }));

        onChangeOf(model.message).execute(((oldValue, newValue) -> System.out.println(newValue)));
    }
}
