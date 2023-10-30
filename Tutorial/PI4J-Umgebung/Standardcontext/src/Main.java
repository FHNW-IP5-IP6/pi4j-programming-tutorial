import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

import com.pi4j.catalog.components.base.PIN;

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
                .add(PiGpioDigitalOutputProvider.newInstance(piGpio))
                .build();

        // Run the application
        System.out.println("Application is running");

        // Create a new SimpleLED component
        SimpleLed led = new SimpleLed(pi4j, PIN.PWM19);

        // Turn on the LED to have a defined state
        led.on();
        sleep(1000);

        // Make a flashing light by toggling the LED every second
        for (int i = 0; i < 10; i++) {
            System.out.println(led.toggle());
            sleep(1000);
        }

        // That's all so turn off the relay and quit
        led.off();

        // End of application
        System.out.println("Application is done");

        // Clean up
        pi4j.shutdown();
    }
}