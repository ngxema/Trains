import java.util.Objects;

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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Route route1 = (Route) o;

    if (distance != route1.distance) {
      return false;
    }
    return Objects.equals(route, route1.route);

  }

  @Override
  public int hashCode() {
    int result = route != null ? route.hashCode() : 0;
    result = 31 * result + distance;
    return result;
  }

  @Override
  public String toString() {
    return "Route{" +
        "route='" + route + '\'' +
        ", distance=" + distance +
        '}';
  }
}
