package fr.craftinglabs.pi.matrix;

import java.util.Arrays;

public class Segment {
    public static final int SIZE = 8;
    private int[] segment;

    public Segment(int[] segment) {
        if (segment.length != 8) throw new IllegalArgumentException("Segment should have a size of 8 but created with size of " + segment.length);

        this.segment = segment;
    }

    public byte toByte() {
        int value = 0;
        for (int i = 0; i < 8; i++) {
            value += (int) (Math.pow(2, i) * segment[i]);
        }

        return (byte) value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int element: segment) {
            builder.append(element);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment1 = (Segment) o;

        return Arrays.equals(segment, segment1.segment);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(segment);
    }
}
