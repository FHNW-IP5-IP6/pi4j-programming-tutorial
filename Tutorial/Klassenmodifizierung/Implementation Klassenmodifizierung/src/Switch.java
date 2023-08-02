import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.PullResistance;


import com.pi4j.catalog.components.base.DigitalSensor;
import com.pi4j.catalog.components.base.PIN;

import static com.pi4j.io.gpio.digital.DigitalInput.DEFAULT_DEBOUNCE;

public class Switch extends DigitalSensor {
    /**
     * Specifies if switch state is inverted, e.g. HIGH = on, LOW = off
     * This will also automatically switch the pull resistance to PULL_UP
     */
    private final boolean inverted;
    /**
     * Runnable Code when switch is 'on'
     */
    private Runnable onSwitchOn;
    /**
     * Runnable Code when switch is 'off'
     */
    private Runnable onSwitchOff;

    /**
     * Creates a new button component
     *
     * @param pi4j Pi4J context
     */
    public Switch(Context pi4j, PIN address) {
        this(pi4j, address, false, DEFAULT_DEBOUNCE);
    }

    /**
     * Creates a new switch component with custom GPIO address and debounce time.
     *
     * @param pi4j     Pi4J context
     * @param address  GPIO address of button
     * @param inverted Specify if switch state is inverted
     * @param debounce Debounce time in microseconds
     */
    public Switch(Context pi4j, PIN address, boolean inverted, long debounce) {
        super(pi4j,
                DigitalInput.newConfigBuilder(pi4j)
                        .id("BCM" + address)
                        .name("Switch #" + address)
                        .address(address.getPin())
                        .debounce(debounce)
                        .pull(inverted ? PullResistance.PULL_UP : PullResistance.PULL_DOWN)
                        .build());

        this.inverted = inverted;

        /*
         * Gets a DigitalStateChangeEvent directly from the provider.
         * This runs in a different Thread than main.
         * <p>
         * Listener is only called of the DigitalState has changed.
         */
        digitalInput.addListener(digitalStateChangeEvent -> {
            DigitalState state = getState();

            logDebug("Switched to '%s'", state);

            switch (state) {
                case LOW -> {
                    if (onSwitchOff != null) {
                        logDebug("onSwitchOff triggered");
                        onSwitchOff.run();
                    }
                }
                case HIGH -> {
                    if (onSwitchOn != null) {
                        logDebug("onSwitchOn triggered");
                        onSwitchOn.run();
                    }
                }
                case UNKNOWN -> logError("Button is in State UNKNOWN");
            }
        });
    }

    /**
     * Checks if switch is currently 'on'.
     * <p>
     * For a not-inverted switch this means: if the switch is 'on', then full voltage is present
     * at the GPIO-Pin. Therefore, the DigitalState is HIGH
     *
     * @return true if button is pressed
     */
    public boolean isOn() {
        return getState() == DigitalState.HIGH;
    }

    /**
     * Checks if switch is currently 'off'
     * <p>
     * For a not-inverted switch this means: if the switch is 'off', then no voltage is present
     * at the GPIO-Pin. Therefore, the DigitalState is LOW
     *
     * @return true if button is depressed
     */
    public boolean isOff() {
        return getState() == DigitalState.LOW;
    }


    /**
     * Sets or disables the handler for the onDown event.
     * <p>
     * This event gets triggered whenever the switch is turned to 'off'.
     * Only a single event handler can be registered at once.
     *
     * @param task Event handler to call or null to disable
     */
    public void onSwitchOff(Runnable task) {
        onSwitchOff = task;
    }

    /**
     * Sets or disables the handler for the onUp event.
     * <p>
     * This event gets triggered whenever the switch is turned to 'on'.
     * Only a single event handler can be registered at once.
     *
     * @param task Event handler to call or null to disable
     */
    public void onSwitchOn(Runnable task) {
        onSwitchOn = task;
    }

    /**
     * disables all the handlers for the onUp, onDown and WhileDown Events
     */
    @Override
    public void reset() {
        onSwitchOff = null;
        onSwitchOn = null;
    }

    /**
     * Returns the current state of the Digital State
     *
     * @return Current DigitalInput state (Can be HIGH, LOW or UNKNOWN)
     */
    private DigitalState getState() {
        return switch (digitalInput.state()) {
            case HIGH -> inverted ? DigitalState.LOW  : DigitalState.HIGH;
            case LOW  -> inverted ? DigitalState.HIGH : DigitalState.LOW;
            default   -> DigitalState.UNKNOWN;
        };
    }

}

