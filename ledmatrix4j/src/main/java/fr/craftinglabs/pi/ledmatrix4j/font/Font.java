package fr.craftinglabs.pi.ledmatrix4j.font;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Font {
    private final Map<Character, Glyph> glyphs = new HashMap<>();

    public Font(List<Glyph> glyphs) {
        for(Glyph glyph: glyphs)
            this.glyphs.put(glyph.getChar(), glyph);
    }

    public Glyph glyphFor(Character character) {
        return glyphs.get(character);
    }
}
