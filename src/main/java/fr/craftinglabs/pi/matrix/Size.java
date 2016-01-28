package fr.craftinglabs.pi.matrix;

public class Size {

    private final int length;
    private final int height;

    public Size(int height, int length) {
        this.height = height;
        this.length = length;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getLength() {
        return length;
    }
}
