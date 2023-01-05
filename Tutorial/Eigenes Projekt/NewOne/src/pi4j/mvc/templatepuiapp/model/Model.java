package pi4j.mvc.templatepuiapp.model;

import pi4j.mvc.util.mvcbase.ObservableValue;
import java.util.ArrayList;
import java.util.List;

public class Model {
    /**
     * current level
     */
    public final ObservableValue<Integer> level = new ObservableValue<>(0);

    /**
     * how many led are glowing during the first round
     */
    public final ObservableValue<Integer> startNumberOfLed = new ObservableValue<>(3);

    /**
     * state led 0
     */
    public final ObservableValue<Boolean> led0IsGlowing = new ObservableValue<>(false);
    /**
     * state led 1
     */
    public final ObservableValue<Boolean> led1IsGlowing = new ObservableValue<>(false);
    /**
     * state led 2
     */
    public final ObservableValue<Boolean> led2IsGlowing = new ObservableValue<>(false);
    /**
     * state led 3
     */
    public final ObservableValue<Boolean> led3IsGlowing = new ObservableValue<>(false);

    /**
     * current sequence for the level
     */
    public final ObservableValue<ArrayList<Integer>> sequence = new ObservableValue<>(new ArrayList<>(List.of(0,0,0,0,0,0,0,0,0,0)));

    /**
     * number of led which already have been pressed right
     */
    public final ObservableValue<Integer> numberOfPressedLed = new ObservableValue<>(0);
    /**
     * message is shown as output to player
     */
    public final ObservableValue<String> message = new ObservableValue<>("Welcome to Simon Says, pleas press any button to start the game.");

}
