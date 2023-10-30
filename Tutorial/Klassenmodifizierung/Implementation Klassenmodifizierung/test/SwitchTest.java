import com.pi4j.catalog.ComponentTest;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pi4j.catalog.components.base.PIN;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchTest extends ComponentTest {

    private Switch aSwitch;
    private MockDigitalInput digitalInput;
    private final PIN pinNumber = PIN.D26;

    @BeforeEach
    public void setUp() {
        aSwitch = new Switch(pi4j, pinNumber);
        digitalInput = aSwitch.mock();
    }

    @Test
    public void testIsSwitchOn() {
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertTrue(aSwitch.isOn());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertFalse(aSwitch.isOn());
    }

    @Test
    public void testIsSwitchOff() {
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertFalse(aSwitch.isOff());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertTrue(aSwitch.isOff());
    }
    @Test
    public void testOnSwitchOn() {
        //given
        Counter counter = new Counter();
        digitalInput.mockState(DigitalState.LOW);
        aSwitch.onSwitchOn(() -> counter.increase());

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter.count);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter.count);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(1, counter.count);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(2, counter.count);
    }

    @Test
    public void testOnSwitchOff() {
        //given
        Counter counter = new Counter();
        digitalInput.mockState(DigitalState.LOW);
        aSwitch.onSwitchOff(() -> counter.increase());

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(0, counter.count);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(1, counter.count);

        //when
        digitalInput.mockState(DigitalState.HIGH);

        //then
        assertEquals(1, counter.count);

        //when
        digitalInput.mockState(DigitalState.LOW);

        //then
        assertEquals(2, counter.count);
    }

    private class Counter {
        int count;

        void increase(){
            count++;
        }
    }
}