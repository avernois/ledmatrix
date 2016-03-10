package fr.craftinglabs.pi.ledmatrix4j.font;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FontTest {

    @Test
    public void should_be_made_of_glyphs() {
        Glyph g1 = new Glyph('1',
                "0010",
                "0010",
                "0010",
                "0010");

        Font font = new Font(Arrays.asList(g1));

        assertEquals(g1, font.glyphFor('1'));
    }
}