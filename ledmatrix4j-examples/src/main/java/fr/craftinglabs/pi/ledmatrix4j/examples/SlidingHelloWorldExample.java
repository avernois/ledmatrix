package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font9;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;

import java.time.Duration;
import java.util.Arrays;

import static fr.craftinglabs.pi.ledmatrix4j.font.Font9.*;

public class SlidingHelloWorldExample {
 
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(new Size(9, 32));

        matrix.print(Duration.ofMillis(300), new SlidingGlyphs(new Size(9, 32), Arrays.asList(H, e, l, l, o, SPACE, W, o, r, l, d, EXCLAMATION)));
        matrix.print(Duration.ofMillis(300), new SlidingGlyphs(new Size(9, 32), Arrays.asList(B, o, n, j, o, u, r, SPACE, l, e, SPACE, m, o, n, d, e, EXCLAMATION )));
    }
}