package fr.craftinglabs.pi.matrix.font;

import java.util.HashMap;
import java.util.Map;

public class Font {
    static final Map<Character, Glyph> glyphs = new HashMap<>();

    static public void add(Glyph glyph) {
        glyphs.put(glyph.getChar(), glyph);
    }

    static public Glyph glyphFor(Character character) {
        return glyphs.get(character);
    }
}
