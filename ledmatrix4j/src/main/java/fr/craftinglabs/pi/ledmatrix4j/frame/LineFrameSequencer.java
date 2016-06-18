package fr.craftinglabs.pi.ledmatrix4j.frame;

import fr.craftinglabs.pi.ledmatrix4j.Size;

import java.util.ArrayList;
import java.util.List;

public class LineFrameSequencer {
    public List<Frame> Execute(Frame frame) {
        List<Frame> frames = new ArrayList<>();

        List<SegmentedLine> lines = frame.toLines();
        for (int i = 0; i < lines.size(); i++) {
            List<SegmentedLine> emptyFrame = generateEmptyFrame(frame.size());
            emptyFrame.set(i, lines.get(i));
            frames.add(new Frame(emptyFrame.toArray(new SegmentedLine[emptyFrame.size()])));
        }

        return frames;
    }

    private List<SegmentedLine> generateEmptyFrame(Size size){
        List<SegmentedLine> lines = new ArrayList<>();
        for (int lineNum = 0; lineNum < size.getHeight(); lineNum++) {
            lines.add(new SegmentedLine(new int[size.getLength()]));
        }

        return lines;
    }
}
