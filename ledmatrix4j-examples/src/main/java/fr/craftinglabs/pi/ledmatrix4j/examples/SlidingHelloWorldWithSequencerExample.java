package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font9;
import fr.craftinglabs.pi.ledmatrix4j.font.Glyph;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencer;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencerIterable;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;

import java.time.Duration;
import java.util.Arrays;

import static fr.craftinglabs.pi.ledmatrix4j.font.Font9.*;

public class SlidingHelloWorldWithSequencerExample {
 
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(new Size(9, 32));
        Duration delayByFrame = Duration.ofSeconds(40);

        matrix.print(delayByFrame, format(H, e, l, l, o, SPACE, W, o, r, l, d, EXCLAMATION));
        matrix.print(delayByFrame, format(B, o, n, j, o, u, r, SPACE, l, e, SPACE, m, o, n, d, e, EXCLAMATION));
    }

    private static LineFrameSequencerIterable format(Glyph... characters){
        SlidingGlyphs glyphs = new SlidingGlyphs(
                new Size(9, 32),
                Arrays.asList(characters));
        return new LineFrameSequencerIterable(
                glyphs.iterator(),
                new LineFrameSequencer());
    }
}