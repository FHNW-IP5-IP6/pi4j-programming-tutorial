package com.pi4j.mvc.templatepuiapp.controller;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.templatepuiapp.view.pui.PUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ControllerTest {
    Context pi4j = Pi4J.newAutoContext();
    Model model = new Model();
    Controller controller = new Controller(model);
    PUI pui = new PUI(controller, pi4j);

    @Test
    public void testController() {
        assertDoesNotThrow(() -> controller.notifyAll());
    }
}
