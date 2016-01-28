package fr.craftinglabs.pi.matrix;

import com.pi4j.io.gpio.*;
import fr.craftinglabs.pi.matrix.io.MatrixGPIO;

public class MainTest {
 
    public static void main(String[] args) throws InterruptedException {

        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput shiftData = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Shift Data", PinState.LOW);
        final GpioPinDigitalOutput shiftClock = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Shift Clock", PinState.LOW);
        final GpioPinDigitalOutput shiftLatch = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Shift Latch", PinState.LOW);

        final GpioPinDigitalOutput counterClock = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "Counter Clock", PinState.LOW);
        final GpioPinDigitalOutput counterReset = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "Counter Reset", PinState.LOW);

        shiftData.setShutdownOptions(true, PinState.LOW);
        shiftClock.setShutdownOptions(true, PinState.LOW);
        shiftLatch.setShutdownOptions(true, PinState.LOW);
        counterClock.setShutdownOptions(true, PinState.LOW);
        counterReset.setShutdownOptions(true, PinState.LOW);

        shiftLatch.low();

        Matrix matrix = new Matrix(new Size(10, 32), new MatrixGPIO(shiftData, shiftClock, shiftLatch, counterClock, counterReset));

        Frame frame = new Frame(new SegmentedLine(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                new SegmentedLine(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                new SegmentedLine(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        matrix.print(1, frame);

        gpio.shutdown();    
    }

}