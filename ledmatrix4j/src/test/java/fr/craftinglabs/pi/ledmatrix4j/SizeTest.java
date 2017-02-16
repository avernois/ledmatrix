package fr.craftinglabs.pi.ledmatrix4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class SizeTest {

    @Test public void
    should_have_height() {
        assertEquals(2, new Size(2, 8).getHeight());
    }

    @Test public void
    should_have_length() {
        assertEquals(8, new Size(2, 8).getLength());
    }

    @Test public void
    should_have_a_string_representation() {
        assertEquals("2x8", new Size(2,8).toString());
    }
}