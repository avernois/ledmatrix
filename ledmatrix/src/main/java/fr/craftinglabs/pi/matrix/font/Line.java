package fr.craftinglabs.pi.matrix.font;

public class Line {

    private String line;

    public Line(String line) {

        this.line = line;
    }

    public int getLength() {
        return line.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line1 = (Line) o;

        return line.equals(line1.line);
    }

    @Override
    public int hashCode() {
        return line.hashCode();
    }

    public Line concat(Line line2) {
        return new Line(this.toString() + line2.toString());
    }

    @Override
    public String toString() {
        return line;
    }

    public Line subLine(int length, int offset) {
        return new Line(line.substring(offset, offset + length));
    }
}
