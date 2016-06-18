package fr.craftinglabs.pi.ledmatrix4j;

import fr.craftinglabs.pi.ledmatrix4j.frame.Frame;
import fr.craftinglabs.pi.ledmatrix4j.frame.Segment;
import fr.craftinglabs.pi.ledmatrix4j.frame.SegmentedLine;
import fr.craftinglabs.pi.ledmatrix4j.io.MatrixGPIO;
import fr.craftinglabs.pi.ledmatrix4j.io.MatrixIO;

import java.time.Duration;

public class Matrix {

    private final MatrixIO io;
    private final SequenceRepeater sequenceRepeater;

    private final Size size;


    public Matrix(Size size) {
        this(size, new MatrixGPIO(), new SequenceRepeater());
    }

    public Matrix(Size size, MatrixIO matrixIO, SequenceRepeater sequenceRepeater) {
        this.size = size;
        this.io = matrixIO;
        this.sequenceRepeater = sequenceRepeater;
        clearLine();
    }

    public void print(int speed, Frame frame) {
        sequenceRepeater.Run(() -> {
            goFirstLine();
            printFrame(frame);
        }, Duration.ofMillis(speed));
    }

    public void print(int speed, Iterable<Frame> frames) {
        for(Frame frame: frames) {
            print(speed, frame);
        }
    }

    private void printFrame(Frame frame) {
        for (SegmentedLine line: frame.toLines()) {
            printLine(line);
            clearLine();
            goNextLine();
        }
    }

    private void goFirstLine() {
        io.resetCounter();
    }

    private void goNextLine() {
        io.incrementCounter();
    }

    private void printLine(SegmentedLine line) {
        for (Segment segment : line.segments()) {
            io.shiftLine(segment.toByte());
        }
        io.releaseShift();
    }

    private void clearLine() {
        for (int i = 0; i < size.getLength() / Segment.SIZE; i++) {
            io.shiftLine((byte) 0);
        }
        io.releaseShift();
    }
}