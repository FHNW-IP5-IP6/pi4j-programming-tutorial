package com.pi4j.mvc.templatepuiapp.model;

import com.pi4j.mvc.util.mvcbase.ObservableValue;

import java.util.ArrayList;
import java.util.List;

public class Model {
    /* Possible Solution:
        A Variable, which indicates, which LED has to light right now. With an unused number, all LEDs are reset.
        A Variable, which holds the current shuffled series of indexes from the lights. When a wrong input is given, the
        series is reset.
        A Variable, which saves the current given Index of the series. It is increased, when we give in the right input,
        and reset, when we give the wrong input.
        A Variable, which holds Output-Messages. Not really needed, as the PUI doesn't include a part to display it, but
        still valuable, if the app is started in debug-mode.
     */
    public final ObservableValue<Integer> glowingLED = new ObservableValue<>(4);
    public final ObservableValue<ArrayList<Integer>> currentSeries = new ObservableValue<>(new ArrayList<>(List.of(0, 1, 2, 3)));
    public final ObservableValue<Integer> currentIndex = new ObservableValue<>(0);
    public final ObservableValue<String> message = new ObservableValue<>("");
}
