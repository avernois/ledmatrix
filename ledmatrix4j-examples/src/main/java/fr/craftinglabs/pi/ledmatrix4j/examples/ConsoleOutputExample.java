package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.SequenceRepeater;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;
import fr.craftinglabs.pi.ledmatrix4j.font.Font6;
import fr.craftinglabs.pi.ledmatrix4j.io.ConsoleMatrixIO;

import java.util.Arrays;

import static fr.craftinglabs.pi.ledmatrix4j.font.Font6.*;

public class ConsoleOutputExample {
 
    public static void main(String[] args) throws InterruptedException {

        Matrix matrix = new Matrix(new Size(6, 8), new ConsoleMatrixIO(), new SequenceRepeater());

        matrix.print(100, new SlidingGlyphs(new Size(6, 8), Arrays.asList(H, e, l, l, o, SPACE, W, o, r, l, d, MARK)));
    }
}