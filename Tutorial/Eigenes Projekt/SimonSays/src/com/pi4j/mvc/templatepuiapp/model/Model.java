package com.pi4j.mvc.templatepuiapp.model;

import com.pi4j.mvc.util.mvcbase.ObservableArray;
import com.pi4j.mvc.util.mvcbase.ObservableValue;

public class Model {
    /**
     * An Array of the glowing LEDs
     */
    public final ObservableArray<Boolean> ledsGlowing = new ObservableArray<>(new Boolean[]{false, false, false, false});
    /**
     * message is shown as output to player
     */
    public final ObservableValue<String> message = new ObservableValue<>("Welcome to Simon Says, pleas press any button to start the game.");
}
