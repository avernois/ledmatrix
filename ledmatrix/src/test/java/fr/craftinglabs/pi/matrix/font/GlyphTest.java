package fr.craftinglabs.pi.matrix.font;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GlyphTest {
    @Test
    public void should_have_a_height_of_1_when_made_of_one_line() {
        Glyph glyph = new Glyph('1', "0010");

        assertEquals(1, glyph.getHeight());
    }

    @Test
    public void should_have_a_height_that_match_number_of_lines_in_the_glyph() {
        Glyph glyph = new Glyph('1',
                "0010",
                "0010",
                "0010",
                "0010");

        assertEquals(4, glyph.getHeight());
    }

    @Test
    public void should_represent_a_character() {
        Glyph glyph = new Glyph('1',
                "0010",
                "0010",
                "0010",
                "0010");

        assertEquals('1', glyph.getChar());
    }

    @Test
    public void should_have_a_representation_as_list_of_lines() {
        Glyph glyph = new Glyph('1',
                "0010",
                "0010",
                "0010",
                "0010");

        List<Line> lines = glyph.toLines();

        List<Line> expectedLines = Arrays.asList(new Line("0010"),new Line("0010"), new Line("0010"), new Line("0010"));
        assertEquals(expectedLines, lines);
    }
}