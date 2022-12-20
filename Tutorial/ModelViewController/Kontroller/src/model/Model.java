package model;

import util.mvcbase.ObservableValue;

public class Model {
    public final ObservableValue<Integer> counter  = new ObservableValue<>(0);
    public final ObservableValue<Boolean> ledGlows = new ObservableValue<>(false);
}
