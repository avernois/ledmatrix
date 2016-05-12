package fr.craftinglabs.pi.ledmatrix4j.frame;

import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Frame {
    private final List<SegmentedLine> lines = new LinkedList<>();
    private final Size size;

    public Frame(SegmentedLine... lines) {
        this.lines.addAll(Arrays.asList(lines));
        size = new Size(lines.length, lines[0].segments().size()*Segment.SIZE);
    }

    public Frame(String... lines) {
        for(String line: lines) {
            this.lines.add(new SegmentedLine(line));
        }
        size  = new Size(lines.length, lines[0].length());
    }

    public Frame(Line... lines) {
        for(Line line: lines) {
            this.lines.add(new SegmentedLine(line.toString()));
        }

        size = new Size(lines.length, lines[0].getLength());
    }

    public List<SegmentedLine> toLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Frame frame = (Frame) o;

        return lines.equals(frame.lines);
    }

    @Override
    public int hashCode() {
        return lines.hashCode();
    }

    public Size size() {
        return size;
    }
}