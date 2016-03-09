package fr.craftinglabs.pi.ledmatrix4j.font;

import java.util.LinkedList;
import java.util.List;

public class Glyph {
    private final Character character;
    private final List<Line> lines = new LinkedList<>();
    private int height;

    public Glyph(Character character, String... lines) {
        this.character = character;
        for(String line: lines) {
            this.lines.add(new Line(line));
        }

        this.height = lines.length;
    }

    public int getHeight() {
        return height;
    }

    public char getChar() {
        return character;
    }

    public List<Line> toLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Glyph glyph = (Glyph) o;

        if (height != glyph.height) return false;
        if (!character.equals(glyph.character)) return false;

        return lines.equals(glyph.lines);
    }

    @Override
    public int hashCode() {
        int result = character.hashCode();
        result = 31 * result + lines.hashCode();
        result = 31 * result + height;
        return result;
    }
}
