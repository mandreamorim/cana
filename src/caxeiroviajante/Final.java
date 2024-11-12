package caxeiroviajante;

public class Final implements Comparable<Final>{
    String path;
    double distance;

    public Final(String path, double distance) {
        this.path = path;
        this.distance = distance;
    }

    @Override
    public int compareTo(Final o) {
        return Double.compare(distance, o.distance);
    }
}
