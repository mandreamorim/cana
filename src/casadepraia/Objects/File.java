package casadepraia.Objects;

public class File {
    public int pages;
    public int size;
    public double density;
    public String name;

    public File(int pages, int size) {
        this.pages = pages;
        this.size = size;
        density = (double) pages / (double) size;
    }

    public File(int pages, int size, String name) {
        this.pages = pages;
        this.size = size;
        this.name = name;
        density = (double) pages / (double) size;
    }

    @Override
    public String toString() {
        return "File size: " + size + " pages: " + pages;
    }
}
