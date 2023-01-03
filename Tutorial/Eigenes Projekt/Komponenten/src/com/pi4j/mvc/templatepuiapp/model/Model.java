package com.pi4j.mvc.templatepuiapp.model;

import com.pi4j.mvc.util.mvcbase.ObservableValue;

import java.util.ArrayList;
import java.util.List;

public class Model {
    /**
     * Variable to reset or light up the LEDs
     */
    public final ObservableValue<Integer> glowingLED = new ObservableValue<>(4);
    /**
     * Variable to store the current order of LED of Simon
     */
    public final ObservableValue<ArrayList<Integer>> currentSeries = new ObservableValue<>(new ArrayList<>(List.of(0, 1, 2, 3)));
    /**
     * Variable to store the current index, which was right answered
     */
    public final ObservableValue<Integer> currentIndex = new ObservableValue<>(0);
    /**
     * Variable to store a debug message
     */
    public final ObservableValue<String> message = new ObservableValue<>("");
}
