package fr.craftinglabs.pi.matrix.frame;

import fr.craftinglabs.pi.matrix.Size;
import fr.craftinglabs.pi.matrix.font.Glyph;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SlidingGlyphsTest {

    static final public Glyph glyph = new Glyph( 'a',
            "00000000",
            "01110000",
            "00001000",
            "01111000",
            "10001000",
            "01111000");

    @Test
    public void should_start_with_an_empty_frame() {
        SlidingGlyphs frames = new SlidingGlyphs(new Size(6, 8), glyph);
        Frame frame = frames.iterator().next();

        assertEquals(new Frame("00000000", "00000000", "00000000", "00000000", "00000000", "00000000"), frame);
    }

    @Test
    public void second_frame_should_let_appear_first_column_of_glyph() {
        SlidingGlyphs frames = new SlidingGlyphs(new Size(6, 8), glyph);
        Iterator<Frame> iterator = frames.iterator();
        iterator.next();
        Frame frame = iterator.next();

        assertEquals(new Frame(
                "00000000",
                "00000000",
                "00000000",
                "00000000",
                "00000001",
                "00000000"), frame);
    }

    @Test
    public void third_frame_should_let_appear_second_column_of_glyph() {
        SlidingGlyphs frames = new SlidingGlyphs(new Size(6, 8), glyph);
        Iterator<Frame> iterator = frames.iterator();
        iterator.next();
        iterator.next();
        Frame frame = iterator.next();

        assertEquals(new Frame(
                "00000000",
                "00000001",
                "00000000",
                "00000001",
                "00000010",
                "00000001"), frame);
    }

    @Test
    public void should_end_with_an_empty_frame() {
        SlidingGlyphs frames = new SlidingGlyphs(new Size(6, 8), glyph);
        Frame frame = null;
        Iterator<Frame> iterator = frames.iterator();
        while (iterator.hasNext()) {
            frame = iterator.next();
        }

        assertEquals(new Frame(
                "00000000",
                "00000000",
                "00000000",
                "00000000",
                "00000000",
                "00000000"), frame);
    }

}