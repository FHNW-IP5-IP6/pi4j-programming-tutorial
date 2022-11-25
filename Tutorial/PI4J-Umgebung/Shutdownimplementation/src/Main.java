import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

import static java.lang.Thread.sleep;

public class Main {

    protected static Context pi4j;
    protected static PiGpio piGpio;

    public static void main(String[] args) throws InterruptedException {
        piGpio = PiGpio.newNativeInstance();

        pi4j = Pi4J.newContextBuilder()
                .noAutoDetect()
                .add(new RaspberryPiPlatform() {
                    @Override
                    protected String[] getProviders() {
                        return new String[]{};
                    }
                })
                .add(PiGpioDigitalInputProvider.newInstance(piGpio))
                .build();

        // Run the application
        System.out.println("Application is running");

        final SimpleButton button = new SimpleButton(pi4j, PIN.D26, Boolean.FALSE);

        // Register event handlers
        button.onDown(() -> System.out.println("started pressing the button"));
        button.whilePressed(() -> System.out.println("still pressing the button"), 1000);
        button.onUp(() -> System.out.println("finished pressing the button"));

        // Wait for 15 seconds while handling events before exiting
        System.out.println("Press the button to see it in action!");
        sleep(15_000);

        //deregister the event handlers
        button.deRegisterAll();

        // End of application
        System.out.println("Application is done");

        // Clean up
        pi4j.shutdown();
    }
}