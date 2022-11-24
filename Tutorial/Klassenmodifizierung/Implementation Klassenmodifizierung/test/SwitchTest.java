import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.plugin.mock.provider.gpio.digital.MockDigitalInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchTest extends ComponentTest {

    private Switch aSwitch;
    private MockDigitalInput digitalInput;
    private final PIN PinNumber = PIN.D26;

    @BeforeEach
    public void setUp() {
        aSwitch = new Switch(pi4j, PinNumber, false);
        digitalInput = toMock(aSwitch.getDigitalInput());
    }

    @Test
    public void testGetState() {
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertEquals(DigitalState.HIGH, aSwitch.getState());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //the
        assertEquals(DigitalState.LOW, aSwitch.getState());
        //when
        digitalInput.mockState(DigitalState.UNKNOWN);
        //then
        assertEquals(DigitalState.UNKNOWN, aSwitch.getState());
    }

    @Test
    public void testIsDown() {
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertTrue(aSwitch.isDown());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertFalse(aSwitch.isDown());
    }

    @Test
    public void testIsUp() {
        //when
        digitalInput.mockState(DigitalState.HIGH);
        //then
        assertFalse(aSwitch.isUp());
        //when
        digitalInput.mockState(DigitalState.LOW);
        //then
        assertTrue(aSwitch.isUp());
    }

    @Test
    public void testGetDigitalInput() {
        assertEquals(PinNumber.getPin(), aSwitch.getDigitalInput().address());
    }

    @Test
    public void testOnDown() {
        //given
        int[] counter = {0};
        digitalInput.mockState(DigitalState.LOW);
        aSwitch.onDown(() -> counter[0]++);

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
        aSwitch.deRegisterAll();

        //then
        assertNull(aSwitch.getOnDown());
        assertNull(aSwitch.getOnUp());
    }

    @Test
    public void testOnUp() {
        //given
        int[] counter = {0};
        digitalInput.mockState(DigitalState.LOW);
        aSwitch.onUp(() -> counter[0]++);

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
        aSwitch.deRegisterAll();

        //then
        assertNull(aSwitch.getOnDown());
        assertNull(aSwitch.getOnUp());
    }
}