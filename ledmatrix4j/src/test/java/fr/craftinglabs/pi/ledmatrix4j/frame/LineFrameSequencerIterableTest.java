package fr.craftinglabs.pi.ledmatrix4j.frame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LineFrameSequencerIterableTest {
    @Test
    public void should_use_LineFrameSequencer_to_split_all_frames(){
        List<Frame> source = new ArrayList<>();
        source.add(new Frame("10000000", "01000000"));
        source.add(new Frame("01000000", "00100000"));
        LineFrameSequencerIterable iterable = new LineFrameSequencerIterable(source.iterator(), new SequencerFake());

        List<Frame> result = readAllFrames(iterable.iterator());
        Assert.assertEquals(source.size() * source.get(0).size().getHeight(), result.size());
    }

    private List<Frame> readAllFrames(Iterator<Frame> iterator){
        List<Frame> result = new ArrayList<>();
        while (iterator.hasNext())
        {
            result.add(iterator.next());
        }

        return result;
    }

    private class SequencerFake extends LineFrameSequencer {

    }
}
