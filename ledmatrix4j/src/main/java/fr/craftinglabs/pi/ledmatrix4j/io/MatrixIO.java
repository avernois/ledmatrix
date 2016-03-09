package fr.craftinglabs.pi.ledmatrix4j.io;

public interface MatrixIO {

    void incrementCounter();

    void resetCounter();

    void releaseShift() ;

    void shiftLine(byte value);
}
