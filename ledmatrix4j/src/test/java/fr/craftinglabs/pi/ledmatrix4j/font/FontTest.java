package fr.craftinglabs.pi.ledmatrix4j.font;

import org.junit.Test;
import static org.junit.Assert.*;

public class FontTest {

    @Test
    public void should_be_made_of_glyphs() {
        Font font = new Font();
        Glyph g1 = new Glyph('1',
                "0010",
                "0010",
                "0010",
                "0010");
        Font.add(g1);

        assertEquals(g1, Font.glyphFor('1'));
    }
}