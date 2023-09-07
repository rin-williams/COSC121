public class Sweater implements Comparable<Sweater> {
    private int size = 0;
    private String colour;

    public Sweater(int size, String colour) {
        this.size = size;
        this.colour = colour;
    }

    public Sweater(int size) {
        this(size, "black");
    }

    public String getColour() {
        return colour;
    }

    public int getSize() {

        return size;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setSize(int size) {
        if (size >= 0 && size <= 30)
            this.size = size;

    }

    @Override
    public String toString() {
        return "Sweater [colour=" + colour + ", size=" + size + "]";
    }

    @Override
    public int compareTo(Sweater o) {
        if (this.size > o.size) {
            return 1;
        } else if (this.size < o.size) {
            return -1;
        } else {
            return 0;
        }
    }
}
