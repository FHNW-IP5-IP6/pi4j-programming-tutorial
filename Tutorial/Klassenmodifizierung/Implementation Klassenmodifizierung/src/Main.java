import com.pi4j.Pi4J;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider;
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider;
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

import com.pi4j.catalog.components.base.PIN;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final var piGpio = PiGpio.newNativeInstance();
        final var pi4j = Pi4J.newContextBuilder()
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
                        LinuxFsI2CProvider.newInstance())
                .build();

        System.out.println("Application is running");

        //***********************************Start coding space************************************

        // Create a new Switch component
        Switch aSwitch = new Switch(pi4j, PIN.D26);

        // Register functions to the States of the switch
        aSwitch.onSwitchOff(() -> System.out.println("Switch turned Off"));
        aSwitch.onSwitchOn(() -> System.out.println("Switch turned On"));

        System.out.println("Toggle the switch to see it in action!");
        sleep(15000);

        // Reset the component before shutting down
        aSwitch.reset();

        //***********************************End coding space**************************************

        // End of application
        System.out.println("Application is done");

        // Clean up
        pi4j.shutdown();
    }
}