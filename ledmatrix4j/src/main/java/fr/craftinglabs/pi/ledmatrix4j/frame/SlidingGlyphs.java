package fr.craftinglabs.pi.ledmatrix4j.frame;

import fr.craftinglabs.pi.ledmatrix4j.Size;
import fr.craftinglabs.pi.ledmatrix4j.font.Glyph;
import fr.craftinglabs.pi.ledmatrix4j.font.Line;


import java.util.Iterator;
import java.util.List;

public class SlidingGlyphs implements Iterable<Frame> {

    Line[] fullText;

    private final Size matrixSize;

    public SlidingGlyphs(Size matrixSize, List<Glyph> glyphs) {
        this.matrixSize = matrixSize;

        concatGlyphsWithSpace(matrixSize, glyphs);
    }

    @Override
    public Iterator<Frame> iterator() {
        return new SlidingSymbolsIterator(matrixSize, fullText);
    }


    private void concatGlyphsWithSpace(Size matrixSize, List<Glyph> glyphs) {
        fullText = new Line[matrixSize.getHeight()];
        Glyph emptyGlyph = emptyGlyph(matrixSize);

        concatIn(fullText, emptyGlyph);

        for(Glyph glyph : glyphs) {
            concatIn(fullText, glyph);
        }

        concatIn(fullText, emptyGlyph);
    }

    private Glyph emptyGlyph(Size matrixSize) {
        String[] glyphLines = new String[matrixSize.getHeight()];

        String emptyLine = getEmptyLine(matrixSize.getLength());

        for(int i = 0; i < glyphLines.length; i++) {
            glyphLines[i] = emptyLine;
        }

        return new Glyph(' ', glyphLines);
    }

    private void concatIn(Line[] lines, Glyph glyph) {
        int i = 0;
        for (Line glyphLine : glyph.toLines()) {
            if(lines[i] != null) {
                lines[i] = lines[i].concat(glyphLine);
            } else {
                lines[i] = glyphLine;
            }
            i++;
        }
    }

    private String getEmptyLine(int length) {
        StringBuilder emptyLineBuilder = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            emptyLineBuilder.append("0");
        }
        return emptyLineBuilder.toString();
    }

    private class SlidingSymbolsIterator implements Iterator<Frame> {

        private final Size matrixSize;
        private final Line[] fullText;
        private int currentFrameIndex = 0;

        public SlidingSymbolsIterator(Size matrixSize, Line[] fullText) {
            this.matrixSize = matrixSize;
            this.fullText = fullText;
        }


        @Override
        public boolean hasNext() {
            return currentFrameIndex + matrixSize.getLength() < fullText[0].getLength();
        }
        
        @Override
        public Frame next() {
            Line lines[] = new Line[matrixSize.getHeight()];
            for (int i = 0; i < matrixSize.getHeight(); i++) {
                lines[i] = fullText[i].subLine(matrixSize.getLength(), currentFrameIndex);
            }
            currentFrameIndex++;

            return new Frame(lines);
        }
    }
}