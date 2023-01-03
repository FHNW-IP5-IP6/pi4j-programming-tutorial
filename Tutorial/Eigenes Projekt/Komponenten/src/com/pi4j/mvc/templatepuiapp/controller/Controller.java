package com.pi4j.mvc.templatepuiapp.controller;

import com.pi4j.mvc.templatepuiapp.model.Model;
import com.pi4j.mvc.util.mvcbase.ControllerBase;

import java.util.Collections;

public class Controller extends ControllerBase<Model> {
    /**
     * Creates a new Controller
     *
     * @param model the new model as input
     */
    public Controller(Model model) {
        super(model);
    }

    /**
     * shuffles the list with the order of SimonSays, and stores it in the model. When the order is defined, it lets the
     * model.glowingLED light up in the correct order, and when all are lighted up, resets them, so the game can be started.
     * Also resets the current index to 0.
     */
    public void shuffle() {
        setValue(model.message, "Simon is shuffling. please wait with pressing the buttons until all LED's are on.");
        // Reset all LEDs
        setValue(model.glowingLED, 4);
        //Shuffling the List with the indices of the buttons
        var givenList = get(model.currentSeries);
        Collections.shuffle(givenList);
        sleep(2000);

        //over the model.glowingLED, we display the button with the index i and wait 2 seconds
        for (int i = 0; i < givenList.size(); i++) {
            setValue(model.glowingLED, givenList.get(i));
            sleep(2000);
        }
        // with the value of 4, we reset all LED's
        setValue(model.glowingLED, 4);

        // store the series and the current index in the model
        setValue(model.message, "You can now begin with the sequence.");
        setValue(model.currentSeries, givenList);
        setValue(model.currentIndex, 0);
    }

    /**
     * checks the series if the given input is the right one at the current index. If yes, the next input is awaited.
     * if no, a new game must be started.
     *
     * @param index the index of the button in the series.
     */
    public void checkSeries(Integer index) {
        // When the last input of the 4 is correct, you win the game.
        if(get(model.currentIndex) == 3 && get(model.currentSeries).get(get(model.currentIndex)) == index){
            setValue(model.glowingLED, index);
            setValue(model.message, "You win. You got the sequence right.");
            newGame();
        }
        // When any input but the last is right, the currentIndex is increased and the game can go on.
        else if (get(model.currentSeries).get(get(model.currentIndex)) == index) {
            setValue(model.glowingLED, index);
            setValue(model.message, "This is the right one. Keep going. you have " +(get(model.currentIndex)+1) + " of 4");
            // for the next run, check the next index
            increase(model.currentIndex);
        }
        // When the input doesn't match the right one in the order, a new game is started
        else if (get(model.currentSeries).get(get(model.currentIndex)) != index) {
            setValue(model.glowingLED, 4);
            setValue(model.message, "You picked the wrong one. You had "+get(model.currentIndex)+" of 4 right.");
            newGame();
        }
        // If anything is wrong.
        else {
            setValue(model.message, "An Error occured.");
            newGame();
        }
    }

    /**
     * start a new game after 5 seconds.
     */
    private void newGame(){
        setValue(model.message, "Please wait 5 seconds for the next game.");
        sleep(5000);
        shuffle();
    }

    /**
     * Shutdown function
     */
    protected void terminate() {
        System.exit(0);
    }

    /**
     * Utility function to sleep for the specified amount of milliseconds.
     * An {@link InterruptedException} will be catched and ignored while setting the interrupt flag again.
     *
     * @param millis Time in milliseconds to sleep
     */
    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
