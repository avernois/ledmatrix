package fr.craftinglabs.pi.matrix.frame;

import fr.craftinglabs.pi.matrix.font.Line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Frame {
    private final List<SegmentedLine> lines = new LinkedList<>();

    public Frame(SegmentedLine... lines) {
        this.lines.addAll(Arrays.asList(lines));
    }

    public Frame(String... lines) {
        for(String line: lines) {
            this.lines.add(new SegmentedLine(line));
        }
    }

    public Frame(Line... lines) {
        for(Line line: lines) {
            this.lines.add(new SegmentedLine(line.toString()));
        }
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
}