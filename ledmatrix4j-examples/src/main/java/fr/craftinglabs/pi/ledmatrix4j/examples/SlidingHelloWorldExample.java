package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font9;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;

public class SlidingHelloWorldExample {
 
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(new Size(9, 32));

        matrix.print(300, new SlidingGlyphs(new Size(9, 32), Font9.H, Font9.e, Font9.l, Font9.l, Font9.o, Font9.SPACE, Font9.W, Font9.o, Font9.r, Font9.l, Font9.d, Font9.EXCLAMATION));
        matrix.print(300, new SlidingGlyphs(new Size(9, 32), Font9.B, Font9.o, Font9.n, Font9.j, Font9.o, Font9.u, Font9.r, Font9.SPACE, Font9.l, Font9.e, Font9.SPACE, Font9.m, Font9.o, Font9.n, Font9.d, Font9.e, Font9.EXCLAMATION ));
    }
}