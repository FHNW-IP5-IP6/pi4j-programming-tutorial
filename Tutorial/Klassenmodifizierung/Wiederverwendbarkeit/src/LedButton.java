import com.pi4j.context.Context;

public class LedButton extends Component {
    protected static final long DEFAULT_DEBOUNCE = 10000;
    protected final SimpleButton button;
    protected final SimpleLED led;

    public LedButton(Context pi4j, PIN buttonAddress, Boolean inverted, PIN ledAddress) {
        this(pi4j, buttonAddress, inverted, ledAddress, DEFAULT_DEBOUNCE);
    }

    public LedButton(Context pi4j, PIN buttonAddress, boolean inverted, PIN ledAddress, long debounce) {
        this.button = new SimpleButton(pi4j, buttonAddress, inverted, debounce);
        this.led    = new SimpleLED(pi4j, ledAddress);
    }

    public void ledSetStateOn() {
        led.on();
    }

}