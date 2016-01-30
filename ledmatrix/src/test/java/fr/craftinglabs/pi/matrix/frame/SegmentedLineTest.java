package fr.craftinglabs.pi.matrix.frame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentedLineTest {

    @Test
    public void should_have_a_representation_as_list_of_segments() {
        SegmentedLine line = new SegmentedLine(0, 1, 0, 1, 0, 1, 0, 1);

        assertEquals(1, line.segments().size());
        assertEquals(new Segment(new int[]{0, 1, 0, 1, 0, 1, 0, 1}), line.segments().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_built_with_not_multiple_of_8_elements() {
        new SegmentedLine(1, 1, 1, 1, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_other_symbol_than_0_or_1() {
        new SegmentedLine(2, 0, 1, 0, 1, 0, 1, 0);
    }
}
