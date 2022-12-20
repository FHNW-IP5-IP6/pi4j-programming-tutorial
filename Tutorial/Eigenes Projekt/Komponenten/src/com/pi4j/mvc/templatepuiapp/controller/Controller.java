package com.pi4j.mvc.templatepuiapp.controller;

import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.util.mvcbase.ControllerBase;

import java.util.Collections;

public class Controller extends ControllerBase<Model> {

    protected final int terminationCount = 10;

    public Controller(Model model) {
        super(model);
    }

    public void shuffle() {
        //Shuffling the List with the indices of the buttons
        setValue(model.message, "Simon is shuffling. please wait with pressing the buttons until all LED's are on.");
        var givenList = get(model.currentSeries);
        Collections.shuffle(givenList);

        //over the model.glowingLED, we display the button with the index i
        for (int i = 0; i < givenList.size(); i++) {
            setValue(model.glowingLED, givenList.get(i));
            sleep(2000);
        }
        // with the value of 4, we reset all LED's
        setValue(model.glowingLED, 4);

        setValue(model.message, "You can now begin with the sequence.");
        setValue(model.currentSeries, givenList);
        setValue(model.currentIndex, 0);
    }

    public void checkSeries(Integer index) {
        if(get(model.currentIndex) == 3 && get(model.currentSeries).get(get(model.currentIndex)) == index){
            setValue(model.message, "You win. You got the sequence right. Please wait 5 seconds for the next.");
            sleep(5000);
            shuffle();
        } else if (get(model.currentSeries).get(get(model.currentIndex)) == index) {
            setValue(model.glowingLED, index);
            setValue(model.message, "This is the right one. Keep going.");
            // for the next run, check the next index
            increase(model.currentIndex);
        } else if (get(model.currentSeries).get(get(model.currentIndex)) != index) {
            setValue(model.glowingLED, 4);
            setValue(model.message, "You picked the wrong one. You had "+index+" of 4 right.");
            shuffle();
        }else {
            setValue(model.message, "An Error occured.");
            shuffle();
        }
    }

    protected void terminate() {
        System.exit(0);
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
