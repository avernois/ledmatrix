package fr.craftinglabs.pi.ledmatrix4j.frame;

import java.util.ArrayList;
import java.util.Iterator;

public class LineFrameSequencerIterable implements Iterable<Frame> {
    private final ArrayList<Frame> frames;

    public LineFrameSequencerIterable(Iterator<Frame> source, LineFrameSequencer sequencer) {
        frames = new ArrayList<>();
        while (source.hasNext()) {
            for (Frame frame : sequencer.Execute(source.next())){
                frames.add(frame);
            }
        }
    }

    @Override
    public Iterator<Frame> iterator() {
        return frames.iterator();
    }
}
