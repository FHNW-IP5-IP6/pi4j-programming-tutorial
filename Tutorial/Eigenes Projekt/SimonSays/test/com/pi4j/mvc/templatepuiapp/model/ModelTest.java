package com.pi4j.mvc.templatepuiapp.model;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.mvc.templatepuiapp.controller.Controller;
import com.pi4j.mvc.templatepuiapp.view.pui.PUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelTest {
    Context pi4j = Pi4J.newAutoContext();
    Model model = new Model();
    Controller controller = new Controller(model);
    PUI pui = new PUI(controller, pi4j);

    @Test
    public void testModel() {
        assertDoesNotThrow(() -> model.notifyAll());
        assertNotNull(model);
    }
}
