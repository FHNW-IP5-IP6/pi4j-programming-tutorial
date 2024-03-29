package com.pi4j.mvc.templatepuiapp.view.pui;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.mvc.simonsaysapp.controller.Controller;
import com.pi4j.mvc.simonsaysapp.model.Model;
import com.pi4j.mvc.simonsaysapp.view.pui.PUI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PUITest {
    Context pi4j = Pi4J.newAutoContext();
    Controller controller = new Controller(new Model());
    PUI pui = new PUI(controller, pi4j);

    @Test
    public void testPUI() {
        Context newContext = Pi4J.newAutoContext();

        //when
        pui.initializeParts();

        //then
        assertEquals(newContext, pi4j);
    }
}
