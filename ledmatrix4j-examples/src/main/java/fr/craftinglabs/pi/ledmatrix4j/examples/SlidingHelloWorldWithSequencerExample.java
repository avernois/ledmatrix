package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font9;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencer;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencerIterable;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;

import java.util.Arrays;

import static fr.craftinglabs.pi.ledmatrix4j.font.Font9.*;

public class SlidingHelloWorldWithSequencerExample {
 
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(new Size(9, 32));

        SlidingGlyphs hello_world = new SlidingGlyphs(new Size(9, 32), Arrays.asList(H, e, l, l, o, SPACE, W, o, r, l, d, EXCLAMATION));
        matrix.print(40000, new LineFrameSequencerIterable(hello_world.iterator(), new LineFrameSequencer()));
        SlidingGlyphs bonjour_monde = new SlidingGlyphs(new Size(9, 32), Arrays.asList(B, o, n, j, o, u, r, SPACE, l, e, SPACE, m, o, n, d, e, EXCLAMATION ));
        matrix.print(40000, new LineFrameSequencerIterable(bonjour_monde.iterator(), new LineFrameSequencer()));
    }
}