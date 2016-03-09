package fr.craftinglabs.pi.ledmatrix4j.io;


import java.util.ArrayList;
import java.util.List;

public class ConsoleMatrixIO implements MatrixIO {


    private List<int[]> lines = new ArrayList<>();

    private boolean useful;

    public ConsoleMatrixIO() {
        useful = false;
    }


    public void incrementCounter() {
        lines.clear();
        useful = true;

    }


    public void resetCounter() {
        lines.clear();
        System.out.println();
        useful = true;
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void releaseShift() {
        if(!useful)
            return;

        for(int[] line: lines) {
            for (int i = 0; i < line.length; i++) {
                System.out.print((line[i] == 1)?"O":" ");
            }
        }
        useful = false;
        System.out.print("A");
        System.out.println();
    }


    public void shiftLine(byte value) {
        int unsignedValue = value & 0xFF;

        int[] line = new int[8];
        for(int i = 7; i >= 0; i--) {
            int pow = (int) Math.pow(2, i);
            if(unsignedValue >= Math.pow(2.0, i)) {
                unsignedValue -= pow;
                line[i] = 1;
            } else {
                line[i] = 0;
            }
        }
        lines.add(line);
    }
}
