import com.pi4j.Pi4J;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider;
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider;
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

import static java.lang.Thread.sleep;

public class Main {

    public static void main (String[] args) throws InterruptedException {

        final var piGpio = PiGpio.newNativeInstance();
        var pi4j = Pi4J.newContextBuilder()
                .noAutoDetect()
                .add(new RaspberryPiPlatform() {
                    @Override
                    protected String[] getProviders() {
                        return new String[]{};
                    }
                })
                .add(PiGpioDigitalInputProvider.newInstance(piGpio),
                        PiGpioDigitalOutputProvider.newInstance(piGpio),
                        PiGpioPwmProvider.newInstance(piGpio),
                        PiGpioSerialProvider.newInstance(piGpio),
                        PiGpioSpiProvider.newInstance(piGpio),
                        LinuxFsI2CProvider.newInstance()
                )
                .build();

        //***********************************Start coding space************************************

        // Run the application
        System.out.println("Application is running");

        //master solution from a previous task
        final SimpleLED led = new SimpleLED(pi4j, PIN.PWM19);

        // Initialize the button component
        final SimpleButton button = new SimpleButton(pi4j, PIN.D26, Boolean.FALSE);

        // Register event handlers
        button.onDown(() -> led.toggleState());

        // Wait for 15 seconds while handling events before exiting
        System.out.println("Press the button to see it in action!");
        sleep(15_000);

        led.off();

        // Unregister all event handlers to exit this application in a clean way
        button.deRegisterAll();

        // End of application
        System.out.println("Application is done");

        //***********************************End coding space**************************************

        // Clean up
        pi4j.shutdown();

    }
}