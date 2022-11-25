import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalInputProvider;
import com.pi4j.plugin.pigpio.provider.gpio.digital.PiGpioDigitalOutputProvider;
import com.pi4j.plugin.pigpio.provider.i2c.PiGpioI2CProvider;
import com.pi4j.plugin.pigpio.provider.pwm.PiGpioPwmProvider;
import com.pi4j.plugin.pigpio.provider.serial.PiGpioSerialProvider;
import com.pi4j.plugin.pigpio.provider.spi.PiGpioSpiProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
  @Test
  public void testSolution() {
    assertTrue(Main.pi4j.hasProvider(String.valueOf(PiGpioDigitalOutputProvider.newInstance(Main.piGpio))));

    assertFalse(Main.pi4j.hasProvider(String.valueOf(PiGpioDigitalInputProvider.newInstance(Main.piGpio))));
    assertFalse(Main.pi4j.hasProvider(String.valueOf(PiGpioPwmProvider.newInstance(Main.piGpio))));
    assertFalse(Main.pi4j.hasProvider(String.valueOf(PiGpioSerialProvider.newInstance(Main.piGpio))));
    assertFalse(Main.pi4j.hasProvider(String.valueOf(PiGpioSpiProvider.newInstance(Main.piGpio))));
    assertFalse(Main.pi4j.hasProvider(String.valueOf(PiGpioI2CProvider.newInstance(Main.piGpio))));
  }
}