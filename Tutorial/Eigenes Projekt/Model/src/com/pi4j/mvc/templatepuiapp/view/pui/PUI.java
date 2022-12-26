package com.pi4j.mvc.templatepuiapp.view.pui;

import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.controller.Controller;
import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.util.mvcbase.PuiBase;

public class PUI extends PuiBase<Model, Controller> {
    //declare all hardware components attached to RaspPi
    //these are protected to give unit tests access to them
    public PUI(Controller controller, Context pi4J) {
        super(controller, pi4J);
    }

    @Override
    public void initializeParts() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void setupUiToActionBindings(Controller controller) {

    }

    @Override
    public void setupModelToUiBindings(Model model) {

    }
}
