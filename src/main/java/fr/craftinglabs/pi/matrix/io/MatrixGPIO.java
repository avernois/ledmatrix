package fr.craftinglabs.pi.matrix.io;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.wiringpi.Shift;
import fr.craftinglabs.pi.matrix.io.MatrixIO;

public class MatrixGPIO implements MatrixIO {

    private final GpioPinDigitalOutput shiftData;
    private final GpioPinDigitalOutput shiftClock;
    private final GpioPinDigitalOutput shiftLacth;
    private final GpioPinDigitalOutput counterClock;
    private final GpioPinDigitalOutput counterReset;

    public MatrixGPIO(GpioPinDigitalOutput shiftData, GpioPinDigitalOutput shiftClock, GpioPinDigitalOutput shiftLacth, GpioPinDigitalOutput counterClock, GpioPinDigitalOutput counterReset) {
        this.shiftData = shiftData;
        this.shiftClock = shiftClock;
        this.shiftLacth = shiftLacth;
        this.counterClock = counterClock;
        this.counterReset = counterReset;
    }

    private void upDown(final GpioPinDigitalOutput pin) {
        pin.high();
        pin.low();
    }

    public void incrementCounter() {
        upDown(counterClock);
    }

    public void resetCounter(){
        upDown(counterReset);
    }

    public void releaseShift() {
        upDown(shiftLacth);
    }

    public void shiftLine(byte value) {
        Shift.shiftOut((byte) shiftData.getPin().getAddress(), (byte) shiftClock.getPin().getAddress(), (byte) Shift.LSBFIRST, value);
    };

}
