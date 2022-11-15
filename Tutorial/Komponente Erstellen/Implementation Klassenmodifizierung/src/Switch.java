import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalInputConfig;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.PullResistance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Switch extends Component {
    protected static final long DEFAULT_DEBOUNCE = 10_000;
    protected final DigitalInput digitalInput;
    protected final boolean inverted;
    protected Runnable onDown;
    protected Runnable onUp;
    protected final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Switch(Context pi4j, PIN address, boolean inverted) {
        this(pi4j, address, inverted, DEFAULT_DEBOUNCE);
    }

    public Switch(Context pi4j, PIN address, boolean inverted, long debounce) {
        this.inverted = inverted;

        this.digitalInput = pi4j.create(buildDigitalInputConfig(pi4j, address, inverted, debounce));

        this.digitalInput.addListener(digitalStateChangeEvent -> {
            DigitalState state = getState();

            logDebug("Button switched to '" + state + "'");

            switch (state) {
                case HIGH -> {
                    if (onDown != null) {
                        onDown.run();
                    }
                }
                case LOW -> {
                    if (onUp != null) {
                        onUp.run();
                    }
                }
                case UNKNOWN -> logError("Button is in State UNKNOWN");
            }
        });
    }

    public DigitalState getState() {
        return switch (digitalInput.state()) {
            case HIGH -> inverted ? DigitalState.LOW  : DigitalState.HIGH;
            case LOW  -> inverted ? DigitalState.HIGH : DigitalState.LOW;
            default   -> DigitalState.UNKNOWN;
        };
    }

    public boolean isDown() {
        return getState() == DigitalState.HIGH;
    }

    public boolean isUp() {
        return getState() == DigitalState.LOW;
    }

    public DigitalInput getDigitalInput() {
        return this.digitalInput;
    }

    private DigitalInputConfig buildDigitalInputConfig(Context pi4j, PIN address, boolean inverted, long debounce) {
        return DigitalInput.newConfigBuilder(pi4j).id("BCM" + address)
                .name("Button #" + address)
                .address(address.getPin())
                .debounce(debounce).pull(inverted ? PullResistance.PULL_UP : PullResistance.PULL_DOWN)
                .build();
    }

    public void onDown(Runnable task) {
        this.onDown = task;
    }

    public void onUp(Runnable task) {
        this.onUp = task;
    }

    public void deRegisterAll() {
        this.onDown = null;
        this.onUp = null;
        this.executor.shutdown();
    }

    public Runnable getOnDown() {
        return onDown;
    }

    public Runnable getOnUp() {
        return onUp;
    }
}
