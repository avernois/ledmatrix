package fr.craftinglabs.pi.matrix.io;

public interface MatrixIO {

    void incrementCounter();

    void resetCounter();

    void releaseShift() ;

    void shiftLine(byte value);
}
