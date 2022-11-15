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

      // Run the application
      System.out.println("Application is running");

      // Create a new Switch component
      Switch aSwitch = new Switch(pi4j, PIN.D26, false);

      // Register functions to the States of the switch
      aSwitch.onUp(() -> System.out.println("Switch is Off"));
      aSwitch.onDown(() -> System.out.println("Switch is On"));

      // Running the App for 15 Seconds
      sleep(15000);

      // DeRegistering functions before shutting down
      aSwitch.deRegisterAll();

      // End of application
      System.out.println("Application is done");

      // Clean up
      pi4j.shutdown();
   }
}