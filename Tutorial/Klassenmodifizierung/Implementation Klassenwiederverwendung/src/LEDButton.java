import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;

public class LEDButton extends Component {
    protected static final long DEFAULT_DEBOUNCE = 10000;
    protected final SimpleButton button;
    protected final SimpleLED led;

    public LEDButton(Context pi4j, PIN buttonAddress, Boolean inverted, PIN ledAddress) {
        this(pi4j, buttonAddress, inverted, ledAddress, DEFAULT_DEBOUNCE);
    }

    public LEDButton(Context pi4j, PIN buttonAddress, boolean inverted, PIN ledAddress, long debounce) {
        this.button = new SimpleButton(pi4j, buttonAddress, inverted, debounce);
        this.led    = new SimpleLED(pi4j, ledAddress);
    }

    public void ledSetState(boolean on) {
        led.setState(on);
    }

    public void ledSetStateOn() {
        led.on();
    }

    public void ledSetStateOff() {
        led.off();
    }

    public boolean ledToggleState() {
        return led.toggleState();
    }

    public DigitalOutput ledGetDigitalOutput() {
        return led.getDigitalOutput();
    }

    public DigitalState btnGetState() { return button.getState(); }

    public boolean btnIsDown() {
        return button.isDown();
    }

    public boolean btnIsUp() {
        return button.isUp();
    }

    public DigitalInput btnGetDigitalInput() {
        return button.getDigitalInput();
    }

    public void btnOnDown(Runnable method) { button.onDown(method); }

    public void btnOnUp(Runnable method) {
        button.onUp(method);
    }

    public void btnWhilePressed(Runnable method, long millis) {button.whilePressed(method, millis); }

    public void btnDeRegisterAll(){ button.deRegisterAll(); }

    public Runnable btnGetOnUp(){return button.getOnUp();}

    public Runnable btnGetOnDown(){return button.getOnDown();}

    public Runnable btnGetWhilePressed(){return button.getWhilePressed();}
}