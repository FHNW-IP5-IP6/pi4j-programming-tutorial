import java.time.Duration;

import com.pi4j.context.Context;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalOutput;

import com.pi4j.catalog.components.base.Component;
import com.pi4j.catalog.components.base.PIN;

public class LedButton extends Component {
    private static final long DEFAULT_DEBOUNCE = 10000;

    private final SimpleButton button;
    private final SimpleLed    led;

    public LedButton(Context pi4j, PIN buttonAddress, Boolean inverted, PIN ledAddress) {
        this(pi4j, buttonAddress, inverted, ledAddress, DEFAULT_DEBOUNCE);
    }

    public LedButton(Context pi4j, PIN buttonAddress, boolean inverted, PIN ledAddress, long debounce) {
        button = new SimpleButton(pi4j, buttonAddress, inverted, debounce);
        led    = new SimpleLed(pi4j, ledAddress);
    }

    public void ledOn() {
        led.on();
    }

    public void ledOff() {
        led.off();
    }

    public boolean ledToggle() {
        return led.toggle();
    }

    public boolean isDown() {
        return button.isDown();
    }

    public boolean isUp() {
        return button.isUp();
    }

    public void onDown(Runnable method) { button.onDown(method); }

    public void onUp(Runnable method) {
        button.onUp(method);
    }

    public void whilePressed(Runnable method, Duration duration) {
        button.whilePressed(method, duration);
    }

    @Override
    public void reset(){
        super.reset();
        button.reset();
        led.reset();
    }

    MockDigitalOutput mockLed(){
        return led.mock();
    }

    MockDigitalInput mockButton() {
        return button.mock();
    }
}