package fr.craftinglabs.pi.ledmatrix4j;

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


    @Override
    public String toString() {
        return height + "x" + length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (length != size.length) return false;
        return height == size.height;

    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + height;
        return result;
    }
}
