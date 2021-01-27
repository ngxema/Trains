

public class Route {

    private String route;
    private int distance;

    Route(String route, int distance) {
        this.route = route;
        this.distance = distance;
    }

    String getRoute() {
        return route;
    }

    int getDistance() {
        return distance;
    }


    @Override
    public String toString() {
        return "Route{" +
                "route='" + route + '\'' +
                ", distance=" + distance +
                '}';
    }
}