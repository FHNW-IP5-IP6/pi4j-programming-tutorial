import java.time.Duration;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

import com.pi4j.catalog.components.base.PIN;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args)  {
        final PiGpio piGpio = PiGpio.newNativeInstance();

        final Context pi4j = Pi4J.newContextBuilder()
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
        button.onDown(() -> System.out.println("button pressed"));
        button.onUp(()   -> System.out.println("button depressed"));

        // Wait for 15 seconds while handling events before exiting
        System.out.println("Press the button to see it in action!");

        sleep15s();

        //deregister the event handlers
        button.reset();

        // End of application
        System.out.println("Application is done");

        // Clean up
        pi4j.shutdown();
    }

    private static void sleep15s() {
        try {
            sleep(15_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}