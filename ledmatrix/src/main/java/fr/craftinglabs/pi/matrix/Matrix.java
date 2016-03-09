package fr.craftinglabs.pi.matrix;

import fr.craftinglabs.pi.matrix.frame.Frame;
import fr.craftinglabs.pi.matrix.frame.Segment;
import fr.craftinglabs.pi.matrix.frame.SegmentedLine;
import fr.craftinglabs.pi.matrix.io.MatrixGPIO;
import fr.craftinglabs.pi.matrix.io.MatrixIO;

public class Matrix {

    private final MatrixIO io;

    private final Size size;


    public Matrix(Size size) {
        this(size, new MatrixGPIO());
    }

    public Matrix(Size size, MatrixIO matrixIO) {
        this.size = size;
        this.io = matrixIO;
        clearLine();
    }

    public void print(int speed, Frame frame) {
        for (int i = 0; i < speed; i++) {
            goFirstLine();
            printFrame(frame);
        }
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