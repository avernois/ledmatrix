package fr.craftinglabs.pi.matrix.io;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Shift;

public class MatrixGPIO implements MatrixIO {

    private final GpioPinDigitalOutput shiftData;
    private final GpioPinDigitalOutput shiftClock;
    private final GpioPinDigitalOutput shiftLatch;
    private final GpioPinDigitalOutput counterClock;
    private final GpioPinDigitalOutput counterReset;


    public MatrixGPIO() {
        this(RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, RaspiPin.GPIO_05);
    }

    public MatrixGPIO(Pin shiftDataPin, Pin shiftClockPin, Pin shiftLatchPin, Pin counterClockPin, Pin counterResetPin) {
        final GpioController gpio = GpioFactory.getInstance();

        shiftData = gpio.provisionDigitalOutputPin(shiftDataPin, "Shift Data", PinState.LOW);
        shiftClock = gpio.provisionDigitalOutputPin(shiftClockPin, "Shift Clock", PinState.LOW);
        shiftLatch = gpio.provisionDigitalOutputPin(shiftLatchPin, "Shift Latch", PinState.LOW);

        counterClock = gpio.provisionDigitalOutputPin(counterClockPin, "Counter Clock", PinState.LOW);
        counterReset = gpio.provisionDigitalOutputPin(counterResetPin, "Counter Reset", PinState.LOW);

        shiftData.setShutdownOptions(true, PinState.LOW);
        shiftClock.setShutdownOptions(true, PinState.LOW);
        shiftLatch.setShutdownOptions(true, PinState.LOW);
        counterClock.setShutdownOptions(true, PinState.LOW);
        counterReset.setShutdownOptions(true, PinState.LOW);
    }

    public MatrixGPIO(GpioPinDigitalOutput shiftData, GpioPinDigitalOutput shiftClock, GpioPinDigitalOutput shiftLatch, GpioPinDigitalOutput counterClock, GpioPinDigitalOutput counterReset) {
        this.shiftData = shiftData;
        this.shiftClock = shiftClock;
        this.shiftLatch = shiftLatch;
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
        upDown(shiftLatch);
    }

    public void shiftLine(byte value) {
        Shift.shiftOut((byte) shiftData.getPin().getAddress(), (byte) shiftClock.getPin().getAddress(), (byte) Shift.LSBFIRST, value);
    }
}
