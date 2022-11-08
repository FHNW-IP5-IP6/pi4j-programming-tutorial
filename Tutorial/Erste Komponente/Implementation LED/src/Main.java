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
    public static void main(String[] args) throws InterruptedException {

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

        // Create a new SimpleLED component
        SimpleLED led = new SimpleLED(pi4j, PIN.PWM19);

        // Turn on the LED to have a defined state
        led.on();
        sleep(1000);

        // Make a flashing light by toggling the LED every second
        for (int i = 0; i < 10; i++) {
        System.out.println(led.toggleState());
        sleep(1000);
        }

        // That's all so turn off the relay and quit
        led.off();

        // End of application
        System.out.println("Application is done");

        //***********************************End coding space**************************************

        // Clean up
        pi4j.shutdown();
    }
}