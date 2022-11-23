import com.pi4j.Pi4J;
import com.pi4j.library.pigpio.PiGpio;
import com.pi4j.plugin.linuxfs.provider.i2c.LinuxFsI2CProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.pigpio.provider.i2c.PiGpioI2CProvider;
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider;
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider;
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider;
import com.pi4j.plugin.raspberrypi.platform.RaspberryPiPlatform;

public class Main {
   public static void main(String[] args) {
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
                      PiGpioI2CProvider.newInstance(piGpio)
              )
              .build();

      // Run the application
      System.out.println("Application is running");

      //do something with the context, like register a button

      // End of application
      System.out.println("Application is done");

      // Clean up
      pi4j.shutdown();
   }
}