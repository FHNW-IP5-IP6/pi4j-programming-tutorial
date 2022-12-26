package com.pi4j.mvc.templatepuiapp.model;

import com.pi4j.mvc.util.mvcbase.ObservableValue;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public final ObservableValue<Integer> glowingLED = new ObservableValue<>(4);
    public final ObservableValue<ArrayList<Integer>> currentSeries = new ObservableValue<>(new ArrayList<>(List.of(0, 1, 2, 3)));
    public final ObservableValue<Integer> currentIndex = new ObservableValue<>(0);
    public final ObservableValue<String> message = new ObservableValue<>("");
}
