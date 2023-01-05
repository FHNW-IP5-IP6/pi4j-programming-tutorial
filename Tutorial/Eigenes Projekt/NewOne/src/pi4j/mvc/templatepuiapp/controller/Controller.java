package pi4j.mvc.templatepuiapp.controller;

import pi4j.mvc.templatepuiapp.model.Model;
import pi4j.mvc.util.mvcbase.ControllerBase;
import java.util.Random;

public class Controller extends ControllerBase<Model> {
    /**
     * Creates a new Controller
     *
     * @param model the new model as input
     */
    public Controller(Model model) {
        super(model);
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
        //if level is 0 start new game
        if(get(model.level) == 0){
            newGame();
        //game is running
        }else{
            //switch on led
            if (btnNumber == 0){
                setValue(model.led0IsGlowing, true);
            }else if (btnNumber == 1){
                setValue(model.led1IsGlowing, true);
            }else if (btnNumber == 2){
                setValue(model.led2IsGlowing, true);
            }else if (btnNumber == 3){
                setValue(model.led3IsGlowing, true);
            }
            //check if right button is pressed
            if(btnNumber == get(model.sequence).get(get(model.numberOfPressedLed))){
                increase(model.numberOfPressedLed);
                sleep(100);
                setValue(model.message, "Your " + get(model.numberOfPressedLed) +" button was button number "+ btnNumber + ". This was right.");
            }else{
                setValue(model.message, "You pressed the wrong button. press any button to restart the game");
                setValue(model.level,0);
                return;
            }

            //check if level is completed
            if(get(model.numberOfPressedLed) >= get(model.startNumberOfLed)+get(model.level)-1){
                setValue(model.message, "You have completed level" + get(model.level));
                increase(model.level);
                //check if game is completed
                if(get(model.level)+get(model.startNumberOfLed) > get(model.sequence).size()){
                    setValue(model.message, "You have finished the game, press any button to restart the game");
                    setValue(model.level,0);
                    return;
                }
                setValue(model.numberOfPressedLed, 0);
                showNewSequence();
            }

        }
    }

    private void reset(){
        setValue(model.numberOfPressedLed, 0);
        setValue(model.level, 1);
    }

    private void showNewSequence(){
        //creat random sequence
        for (int i = 0; i < get(model.sequence).size(); i++){
            Random random = new Random();
            get(model.sequence).set(i, random.nextInt(4));
        }

        setValue(model.message, "Be ready, new sequence is showing");

        sleep(1000);

        //show sequence
        for (int i = 0; i < (get(model.startNumberOfLed)+get(model.level)-1); i++){
            int currentLed = get(model.sequence).get(i);
            if (currentLed == 0){
                setValue(model.led0IsGlowing,true);
                sleep(1000);
                setValue(model.led0IsGlowing,false);
                sleep(500);
            }else if (currentLed == 1){
                setValue(model.led1IsGlowing,true);
                sleep(1000);
                setValue(model.led1IsGlowing,false);
                sleep(500);
            }else if (currentLed == 2){
                setValue(model.led2IsGlowing,true);
                sleep(1000);
                setValue(model.led2IsGlowing,false);
                sleep(500);
            }else if (currentLed == 3){
                setValue(model.led3IsGlowing,true);
                sleep(1000);
                setValue(model.led3IsGlowing,false);
                sleep(100);
            }
        }

        setValue(model.message, "Try now");
    }

    public void switchOff(int btnNumber){
        //switch on led
        if (btnNumber == 0){
            setValue(model.led0IsGlowing, false);
        }else if (btnNumber == 1){
            setValue(model.led1IsGlowing, false);
        }else if (btnNumber == 2){
            setValue(model.led2IsGlowing, false);
        }else if (btnNumber == 3){
            setValue(model.led3IsGlowing, false);
        }
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
