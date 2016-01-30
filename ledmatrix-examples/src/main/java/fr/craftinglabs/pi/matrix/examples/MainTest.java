package fr.craftinglabs.pi.matrix.examples;

import com.pi4j.io.gpio.*;
import fr.craftinglabs.pi.matrix.Matrix;
import fr.craftinglabs.pi.matrix.Size;
import fr.craftinglabs.pi.matrix.SlidingGlyphs;
import fr.craftinglabs.pi.matrix.font.Font6;
import fr.craftinglabs.pi.matrix.io.ConsoleMatrixIO;
import fr.craftinglabs.pi.matrix.io.MatrixGPIO;

public class MainTest {
 
    public static void main(String[] args) throws InterruptedException {

        //Matrix matrix = initWithConsoleOutput(new Size(6, 8));
        Matrix matrix = initWithGPIOOutput(new Size(6, 8));

        matrix.print(10, new SlidingGlyphs(new Size(6, 8), Font6.H, Font6.e, Font6.l, Font6.l, Font6.o, Font6.SPACE, Font6.W, Font6.o, Font6.r, Font6.l, Font6.d, Font6.MARK));
    }

    private static Matrix initWithConsoleOutput(Size size) {
        return new Matrix(size, new ConsoleMatrixIO());
    }

    private static Matrix initWithGPIOOutput(Size size) {
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

        return new Matrix(new Size(10, 32), new MatrixGPIO(shiftData, shiftClock, shiftLatch, counterClock, counterReset));
    }
}