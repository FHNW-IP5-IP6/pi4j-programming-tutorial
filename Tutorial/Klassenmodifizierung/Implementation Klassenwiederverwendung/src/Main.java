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

      // Initialize the LEDbutton component
       LedButton ledButton = new LedButton(pi4j, PIN.D26, Boolean.FALSE, PIN.PWM19);

      // Turn on the LED to have a defined state
      ledButton.ledOn();

      //see the LED for a Second
      sleep(1000);

      // Register event handlers to print a message when pressed (onDown) and depressed (onUp)
      ledButton.btnOnDown(() -> System.out.println("Pressing the Button"));
      ledButton.btnOnUp(()   -> System.out.println("Stopped pressing."));

      // Wait for 15 seconds while handling events before exiting
      System.out.println("Press the button to see it in action!");

      // Make a flashing light by toggling the LED every second
      // in the meantime, the Button can still be pressed, as we only freeze the main thread
      for (int i = 0; i < 15; i++) {
         System.out.println(ledButton.ledToggleState());
         sleep(1000);
      }

      // Unregister all event handlers to exit this application in a clean way
      ledButton.btnDeRegisterAll();
      ledButton.ledOff();

      // End of application
      System.out.println("Application is done");

      // Clean up
      pi4j.shutdown();
   }
}