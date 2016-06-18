package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font6;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencer;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencerIterable;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;
import fr.craftinglabs.pi.ledmatrix4j.io.ConsoleMatrixIO;

import java.util.Arrays;

public class ConsoleOutputWithSequencerExample {
 
    public static void main(String[] args) throws InterruptedException {

        Matrix matrix = new Matrix(new Size(6, 8), new ConsoleMatrixIO());

        SlidingGlyphs glyphs = new SlidingGlyphs(new Size(6, 8), Arrays.asList(Font6.H, Font6.e, Font6.l, Font6.l, Font6.o, Font6.SPACE, Font6.W, Font6.o, Font6.r, Font6.l, Font6.d, Font6.MARK));
        matrix.print(10, new LineFrameSequencerIterable(glyphs.iterator(), new LineFrameSequencer()));
    }
}