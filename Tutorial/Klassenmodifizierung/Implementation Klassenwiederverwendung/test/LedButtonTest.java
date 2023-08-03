import com.pi4j.catalog.ComponentTest;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import com.pi4j.catalog.components.base.PIN;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class LedButtonTest extends ComponentTest {

    private LedButton button;
    private MockDigitalInput digitalInput;
    private MockDigitalOutput digitalOutput;
    private final PIN btnPinNumber = PIN.D26;
    private final PIN ledPinNumber = PIN.D25;

    @BeforeEach
    public void setUp() {
        button = new LedButton(pi4j, btnPinNumber, false, ledPinNumber);
        digitalInput = toMock(button.btnGetDigitalInput());
        digitalOutput = toMock(button.ledGetDigitalOutput());
    }

    @Test
    public void testGetState(){
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertEquals(DigitalState.HIGH, button.btnGetState());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //the
        assertEquals(DigitalState.LOW, button.btnGetState());
        //when
        digitalInput.mockState(DigitalState.UNKNOWN);
        //then
        assertEquals(DigitalState.UNKNOWN, button.btnGetState());
    }

    @Test
    public void testIsDown(){
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertTrue(button.isDown());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertFalse(button.isDown());
    }

    @Test
    public void testIsUp(){
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertFalse(button.isUp());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertTrue(button.isUp());
    }

    @Test
    public void testGetDigitalInput(){
        assertEquals(btnPinNumber.getPin(),button.btnGetDigitalInput().address());
    }

    @Test
    public void testOnDown(){
        //given
        int[] counter = {0};
        digitalInput.mockState(DigitalState.LOW);
        button.onDown(()->counter[0]++);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter[0]);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter[0]);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(1, counter[0]);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(2, counter[0]);

        //when
        button.reset();

        //then
        assertNull(button.btnGetOnUp());
        assertNull(button.btnGetOnDown());
        assertNull(button.btnGetWhilePressed());
    }

    @Test
    public void testOnUp(){
        //given
        int[] counter = {0};
        digitalInput.mockState(DigitalState.LOW);
        button.onUp(()->counter[0]++);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(0, counter[0]);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(1, counter[0]);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter[0]);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(2, counter[0]);

        //when
        button.reset();

        //then
        assertNull(button.btnGetOnUp());
        assertNull(button.btnGetOnDown());
        assertNull(button.btnGetWhilePressed());

    }

    @Test
    public void testWhilePressed() throws InterruptedException {
        //given
        int samplingTime = 100;

        AtomicInteger counter = new AtomicInteger(0);

        button.whilePressed(counter::getAndIncrement, samplingTime);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(0, counter.get());

        //when
        sleep(150);

        //then
        assertEquals(1, counter.get());

        //when
        sleep(100);

        //then
        assertEquals(2, counter.get());

        //when
        button.reset();
        sleep(100);

        //then
        assertEquals(2, counter.get());
        assertNull(button.btnGetOnUp());
        assertNull(button.btnGetOnDown());
        assertNull(button.btnGetWhilePressed());

        //cleanup
        digitalInput.mockState(DigitalState.LOW);

    }

    @Test
    public void testLED_Address(){
        //when
        digitalOutput = toMock(button.ledGetDigitalOutput());
        //then
        assertEquals(ledPinNumber.getPin(), digitalOutput.getAddress());

    }

    @Test
    public void testSetState_On(){
        //when
        button.ledSetState(true);
        //then
        assertEquals(DigitalState.HIGH, digitalOutput.state());
    }

    @Test
    public void testSetState_Off(){
        //when
        button.ledSetState(false);
        //then
        assertEquals(DigitalState.LOW, digitalOutput.state());
    }

    @Test
    public void testSetStateOn(){
        //when
        button.ledOn();
        //then
        assertEquals(DigitalState.HIGH, digitalOutput.state());
    }

    @Test
    public void testSetStateOff(){
        //given
        button.ledOn();
        //when
        button.ledOff();
        //then
        assertEquals(DigitalState.LOW, digitalOutput.state());
    }

    @Test
    public void testToggleState(){
        //when
        button.ledToggleState();
        //then
        assertEquals(DigitalState.HIGH, digitalOutput.state());
    }
}