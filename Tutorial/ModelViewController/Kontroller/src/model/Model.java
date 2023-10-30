package model;

import com.pi4j.mvc.util.mvcbase.ObservableValue;

public class Model {
    public final ObservableValue<Integer> counter = new ObservableValue<>(0);
    public final ObservableValue<Boolean> active  = new ObservableValue<>(false);
}
