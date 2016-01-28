package fr.craftinglabs.pi.matrix;

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

    public List<SegmentedLine> toLines() {
        return lines;
    }
}