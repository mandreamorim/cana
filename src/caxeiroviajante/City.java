package caxeiroviajante;

import java.util.Arrays;

public class City {
    String label;
    int[] position;

    public City(String label, int[] position) {
        this.label = label;
        this.position = position;
    }

    @Override
    public String toString() {
        return "City{" +
                "label='" + label + '\'' +
                ", position=" + Arrays.toString(position) +
                '}';
    }
}
