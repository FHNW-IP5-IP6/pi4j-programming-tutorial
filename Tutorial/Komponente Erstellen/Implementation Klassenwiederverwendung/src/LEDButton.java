import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;

public class LEDButton extends Component {
    protected static final long DEFAULT_DEBOUNCE = 10000;
    protected final SimpleButton button;
    protected final SimpleLED led;

    public LEDButton(Context pi4j, PIN buttonaddress, Boolean inverted, PIN ledaddress) {
        this(pi4j, buttonaddress, inverted, ledaddress, DEFAULT_DEBOUNCE);
    }

    public LEDButton(Context pi4j, PIN buttonaddress, boolean inverted, PIN ledaddress, long debounce) {
        this.button = new SimpleButton(pi4j, buttonaddress, inverted, debounce);
        this.led    = new SimpleLED(pi4j, ledaddress);
    }

    public void LEDsetState(boolean on) {
        led.setState(on);
    }

    public void LEDsetStateOn() {
        led.on();
    }

    public void LEDsetStateOff() {
        led.off();
    }

    public boolean LEDtoggleState() {
        return led.toggleState();
    }

    public DigitalOutput LEDgetDigitalOutput() {
        return led.getDigitalOutput();
    }

    public DigitalState btngetState() { return button.getState(); }

    public boolean btnisDown() {
        return button.isDown();
    }

    public boolean btnisUp() {
        return button.isUp();
    }

    public DigitalInput btngetDigitalInput() {
        return button.getDigitalInput();
    }

    public void onDown(Runnable method) { button.onDown(method); }

    public void onUp(Runnable method) {
        button.onUp(method);
    }

    public void btnwhilePressed(Runnable method, long millis) {button.whilePressed(method, millis); }

    public void btndeRegisterAll(){ button.deRegisterAll(); }

    public Runnable btnGetOnUp(){return button.getOnUp();}

    public Runnable btnGetOnDown(){return button.getOnDown();}

    public Runnable btnGetWhilePressed(){return button.getWhilePressed();}
}