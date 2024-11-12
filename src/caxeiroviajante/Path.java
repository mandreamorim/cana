package caxeiroviajante;

public class Path {
    City[] cities;
    double distance;

    public Path(City[] cities, double distance) {
        this.cities = cities;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Path " +
                "from " + cities[0].label +
                " to " + cities[1].label +
                " is about " + distance;
    }
}
