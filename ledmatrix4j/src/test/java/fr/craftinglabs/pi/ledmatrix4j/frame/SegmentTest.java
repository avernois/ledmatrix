package fr.craftinglabs.pi.ledmatrix4j.frame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentTest {

    @Test
    public void should_return_0_when_segment_is_empty() {
        Segment segment = new Segment(new int[]{0, 0, 0, 0, 0, 0, 0, 0});

        assertEquals(0, segment.toByte());
    }

    @Test
    public void should_return_1_when_first_element_is_1() {
        Segment segment = new Segment(new int[]{1, 0, 0, 0, 0, 0, 0, 0});

        assertEquals(1, segment.toByte());
    }

    @Test
    public void should_return_8_when_fourth_element_is_1() {
        Segment segment = new Segment(new int[]{0, 0, 0, 1, 0, 0, 0, 0});

        assertEquals(8, segment.toByte());
    }

    @Test
    public void should_return_255_when_all_elements_are_1() {
        Segment segment = new Segment(new int[]{1, 1, 1, 1, 1, 1, 1, 1});

        assertEquals((byte) 255, segment.toByte());
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_created_with_less_than_8_elements() {
        new Segment(new int[7]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_created_with_more_than_8_elements() {
        new Segment(new int[9]);
    }

    @Test
    public void should_have_a_string_representation() {
        Segment segment = new Segment(new int[] { 0, 1, 0, 1, 0, 1, 0, 1});

        assertEquals("01010101", segment.toString());
    }

    @Test
    public void should_have_a_fixed_size_of_8() {
        assertEquals(8, Segment.SIZE);
    }
}