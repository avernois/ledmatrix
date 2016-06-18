package fr.craftinglabs.pi.ledmatrix4j.frame;

import org.junit.Test;

import javax.sound.midi.Sequence;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SegmentedLineTest {

    @Test
    public void should_have_a_representation_as_list_of_segments() {
        List<Segment> expectedSegments = Arrays.asList(new Segment(new int[]{0, 1, 0, 1, 0, 1, 0, 1}), 
                                               new Segment(new int[]{1, 0, 1, 0, 1, 0, 1, 0}));

        SegmentedLine line = new SegmentedLine(0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0);

        assertEquals(expectedSegments, line.segments());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_built_with_not_multiple_of_8_elements() {
        new SegmentedLine(1, 1, 1, 1, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_other_symbol_than_0_or_1() {
        new SegmentedLine(2, 0, 1, 0, 1, 0, 1, 0);
    }

    @Test public void
    should_have_a_length() {
        SegmentedLine line = new SegmentedLine(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 );

        assertEquals(16, line.length());
    }

    @Test
    public void should_have_a_string_representation() {
        String lineRepresentation = "1100110011001100";
        SegmentedLine line = new SegmentedLine(lineRepresentation);

        assertEquals(lineRepresentation, line.toString());
    }
}
