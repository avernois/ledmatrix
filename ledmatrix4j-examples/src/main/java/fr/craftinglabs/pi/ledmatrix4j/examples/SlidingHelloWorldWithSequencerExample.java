package fr.craftinglabs.pi.ledmatrix4j.examples;

import fr.craftinglabs.pi.ledmatrix4j.Matrix;
import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Font9;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencer;
import fr.craftinglabs.pi.ledmatrix4j.frame.LineFrameSequencerIterable;
import fr.craftinglabs.pi.ledmatrix4j.frame.SlidingGlyphs;

import java.util.Arrays;

public class SlidingHelloWorldWithSequencerExample {
 
    public static void main(String[] args) throws InterruptedException {
        Matrix matrix = new Matrix(new Size(9, 32));

        SlidingGlyphs hello_world = new SlidingGlyphs(new Size(9, 32), Arrays.asList(Font9.H, Font9.e, Font9.l, Font9.l, Font9.o, Font9.SPACE, Font9.W, Font9.o, Font9.r, Font9.l, Font9.d, Font9.EXCLAMATION));
        matrix.print(40000, new LineFrameSequencerIterable(hello_world.iterator(), new LineFrameSequencer()));
        SlidingGlyphs bonjour_monde = new SlidingGlyphs(new Size(9, 32), Arrays.asList(Font9.B, Font9.o, Font9.n, Font9.j, Font9.o, Font9.u, Font9.r, Font9.SPACE, Font9.l, Font9.e, Font9.SPACE, Font9.m, Font9.o, Font9.n, Font9.d, Font9.e, Font9.EXCLAMATION ));
        matrix.print(40000, new LineFrameSequencerIterable(bonjour_monde.iterator(), new LineFrameSequencer()));
    }
}