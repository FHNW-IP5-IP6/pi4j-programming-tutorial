package com.pi4j.mvc.simonsaysapp.controller;

import com.pi4j.mvc.util.mvcbase.ControllerBase;

import com.pi4j.mvc.simonsaysapp.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller extends ControllerBase<Model> {
    /**
     * current level
     */
    private Integer level = 0;
    /**
     * how many led are glowing during the first round
     */
    private final Integer startNumberOfLed = 4;

    /**
     * current sequence for the level
     */
    private ArrayList<Integer> sequence = new ArrayList<>(List.of(0,0,0,0,0,0,0,0,0,0,0,0,0));

    /**
     * number of led which already have been pressed right
     */
    private Integer numberOfPressedLed = 0;

    /**
     * information if a game is already running
     */
    private Boolean gameIsRunning = false;

    /**
     * Creates a new Controller
     *
     * @param model the new model as input
     */
    public Controller(Model model) {
        super(model);
    }

    /**
     * Method to call right at the startup of the App
     * <p>
     * What happens, when the app is started? does anything have to be triggered?
     * Comes right after setting up the bindings of the Projector
     */
    @Override
    public void startUp(){

    }

    public void newGame(){
        setValue(model.message, "New game is starting.");
        //reset model
        reset();
        //wait until new sequence is shown
        sleep(2000);
        //creat new sequence
        showNewSequence();
    }

    public void buttonPressed(int btnNumber){
        if (!gameIsRunning){
            gameIsRunning = true;
            newGame();
        }else {
            //switch on led
            setValue(model.ledsGlowing, btnNumber, true);
            //check if right button is pressed
            if (btnNumber == sequence.get(numberOfPressedLed)) {
                numberOfPressedLed++;
                setValue(model.message, "Your " + numberOfPressedLed + " button was button number " + btnNumber + ". This was right.");
            } else {
                setValue(model.message, "You pressed the wrong button. press any button to restart the game");
                gameIsRunning = false;
                level = 0;
                return;
            }

            //check if level is completed
            if (numberOfPressedLed >= startNumberOfLed + level) {
                setValue(model.message, "You have completed level" + level);
                level++;
                //check if game is completed
                if (level + startNumberOfLed > sequence.size()) {
                    setValue(model.message, "You have finished the game, press any button to restart the game");
                    gameIsRunning = false;
                    level = 0;
                    return;
                }
                numberOfPressedLed = 0;

                new Thread(() -> showNewSequence()).start();

            }
        }
    }

    private void reset(){
        numberOfPressedLed = 0;
        level = 0;
    }

    private void showNewSequence(){
        //create random sequence
        for (int i = 0; i < sequence.size(); i++){
            Random random = new Random();
            sequence.set(i, random.nextInt(4));
        }

        setValue(model.message, "Be ready, new sequence is showing");

        sleep(1000);

        //show sequence
        for (int i = 0; i < (startNumberOfLed+level); i++){
            int currentLed = sequence.get(i);
            setValue(model.ledsGlowing, currentLed,true);
            sleep(1000);
            setValue(model.ledsGlowing, currentLed,false);
            sleep(500);
        }

        setValue(model.message, "Try now");
    }

    public void switchOff(int btnNumber){
        //switch off led
        setValue(model.ledsGlowing, btnNumber,false);
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
