package com.pi4j.mvc.templatepuiapp.controller;

import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.util.mvcbase.ControllerBase;

import java.util.Collections;

public class Controller extends ControllerBase<Model> {
    public Controller(Model model) {
        super(model);
    }

    protected void terminate() {
        System.exit(0);
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
