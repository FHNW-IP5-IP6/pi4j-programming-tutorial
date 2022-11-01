package com.pi4j.mvc.templatepuiapp.view;
import com.pi4j.catalog.components.SimpleButton;
import com.pi4j.catalog.components.SimpleLED;
import com.pi4j.mvc.templatepuiapp.controller.SomeController;
import com.pi4j.mvc.templatepuiapp.model.SomeModel;
import com.pi4j.mvc.util.Pi4JContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SomePUITest {

    @Test
    public void testImplementation() {
        //given
        SomeModel model      = new SomeModel();
        SomeController controller = new SomeController(model);
        SomePUI pui        = new SomePUI(controller, Pi4JContext.createMockContext());

        //then
        assertTrue(pui.led instanceof SimpleLED);
    }
}
