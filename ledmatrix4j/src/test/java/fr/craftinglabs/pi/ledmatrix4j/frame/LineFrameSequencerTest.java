package fr.craftinglabs.pi.ledmatrix4j.frame;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineFrameSequencerTest {
    @Test
    public void should_generate_1_frame_by_line(){
        Frame frame = new Frame(
                "10000000",
                "01000000",
                "00100000"
        );
        LineFrameSequencer sequencer = new LineFrameSequencer();

        List<Frame> result = sequencer.Execute(frame);

        assertEquals(3, result.size());
        assertEquals(result.get(0), new Frame("10000000", "00000000", "00000000"));
        assertEquals(result.get(1), new Frame("00000000", "01000000", "00000000"));
        assertEquals(result.get(2), new Frame("00000000", "00000000", "00100000"));
    }
}
