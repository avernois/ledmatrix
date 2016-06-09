package fr.craftinglabs.pi.ledmatrix4j.frame;


import java.util.LinkedList;
import java.util.List;

import static java.lang.System.arraycopy;

public class SegmentedLine {


    private List<Segment> segments = new LinkedList<>();

    public SegmentedLine(int ... elements) throws IllegalArgumentException {
        if((elements.length % Segment.SIZE) != 0) {
            throw new IllegalArgumentException("Should only be constructed with multiple of " + Segment.SIZE + " elements. But tried with " + elements.length + " elements.");
        }

        for (int element : elements) {
            if((element != 0) && (element != 1)) {
                throw new IllegalArgumentException("Should only be constructed with 0 or 1 but received " + element);
            }
        }

        for(int segmentIndex = 0; segmentIndex < elements.length /Segment.SIZE; segmentIndex ++) {
            segments.add(segment(segmentIndex, elements));
        }
    }

    public List<Segment> segments() {
        return segments;
    }

    private Segment segment(int segmentIndex, int[] elements) {
        int[] segment = new int[Segment.SIZE];
        arraycopy(elements, 8 * segmentIndex, segment, 0, Segment.SIZE);

        return new Segment(segment);
    }

    public SegmentedLine(String lineAsString) {
        for(int segmentIndex = 0; segmentIndex < lineAsString.length() / Segment.SIZE; segmentIndex++) {
            int[] segment = getSubSegment(segmentIndex, lineAsString);

            segments.add(new Segment(segment));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SegmentedLine that = (SegmentedLine) o;

        return segments.equals(that.segments);
    }

    @Override
    public int hashCode() {
        return segments.hashCode();
    }

    private int[] getSubSegment(int segmentIndex, String lineAsString) {
        int[] segment = new int[Segment.SIZE];

        for(int index = 0; index < Segment.SIZE; index++) {
            segment[index] = toInt(lineAsString.charAt(index + Segment.SIZE*segmentIndex));
        }

        return segment;
    }

    private int toInt(char c) {
        switch (c) {
            case '0': return 0;
            case '1': return 1;

            default:
                throw new IllegalArgumentException("Should only be constructed with 0 or 1 but received " + c);
        }
    }

    public int length() {
        return segments().size() * Segment.SIZE;
    }
}
