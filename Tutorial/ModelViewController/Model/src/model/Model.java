package model;

import util.mvcbase.ObservableValue;

public class Model {
    //Variables that are to be available in the view must be recorded as observables.
    //This allows project-specific functions to be called which automatically update the view
    //in the event of value changes.
    public final ObservableValue<Integer> counter  = new ObservableValue<>(0);
    public final ObservableValue<Boolean> ledGlows = new ObservableValue<>(false);
    public final ObservableValue<String>  message  = new ObservableValue<>("You pressed the Button 0 Times");
}
