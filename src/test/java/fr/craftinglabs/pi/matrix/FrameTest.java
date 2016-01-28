package fr.craftinglabs.pi.matrix;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class FrameTest {

    @Test
    public void should_return_list_of_SegmentedLine_when_build_from_list_of_SegmentedLine() {
        Frame frame = new Frame(
                new SegmentedLine("0101010101010101"),
                new SegmentedLine("1010101010101010"));

        assertEquals(Arrays.asList(
                new SegmentedLine("010101010101010101"),
                new SegmentedLine("101010101010101010")),
                frame.toLines());
    }

    @Test
    public void should_return_list_of_SegmentedLine_when_build_from_list_of_String() {
        Frame frame = new Frame(
                "0101010101010101",
                "1010101010101010");

        assertEquals(Arrays.asList(
                new SegmentedLine("010101010101010101"),
                new SegmentedLine("101010101010101010")),
                frame.toLines());
    }
}
