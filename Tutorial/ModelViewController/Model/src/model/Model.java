package model;


import com.pi4j.mvc.util.mvcbase.ObservableValue;

public class Model {
    //To notify any value change to the View  the attributes of a Model must be observables.
    public final ObservableValue<Integer> counter  = new ObservableValue<>(0);
    public final ObservableValue<Boolean> active = new ObservableValue<>(false);
    public final ObservableValue<String>  message  = new ObservableValue<>("You pressed the button 0 times");
}
