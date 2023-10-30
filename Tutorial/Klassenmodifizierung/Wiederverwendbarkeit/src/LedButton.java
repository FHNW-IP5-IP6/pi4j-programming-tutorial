import com.pi4j.context.Context;

import com.pi4j.catalog.components.base.Component;
import com.pi4j.catalog.components.base.PIN;

public class LedButton extends Component {
    protected static final long DEFAULT_DEBOUNCE = 10000;
    protected final SimpleButton button;
    protected final SimpleLed led;

    public LedButton(Context pi4j, PIN buttonAddress, Boolean inverted, PIN ledAddress) {
        this(pi4j, buttonAddress, inverted, ledAddress, DEFAULT_DEBOUNCE);
    }

    public LedButton(Context pi4j, PIN buttonAddress, boolean inverted, PIN ledAddress, long debounce) {
        button = new SimpleButton(pi4j, buttonAddress, inverted, debounce);
        led    = new SimpleLed(pi4j, ledAddress);
    }

    public void ledOn() {
        //the method call is delegated to led
        led.on();
    }

}