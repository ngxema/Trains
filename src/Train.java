import java.util.ArrayList;
import java.util.List;

public class Train {

  // DECLARATION OF MAIN ATTRIBUTES
  private static final String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
  private static List<Route> routes = new ArrayList<>();

  public static void main(String[] args) {

    // SPLIT ROUTES IN A VECTOR
    String[] routeVector = graph.split(", ");

    for (String route : routeVector) {
      String a1 = route.substring(0, route.length() - 1);
      int a2 = Integer.parseInt(route.substring(route.length() - 1));

      // CHECK IF THE ROUTE IS A VALID ROUTE
      if (a1.chars().allMatch(Character::isLetter) && a1.length() == 2
          && Integer.toString(a2).length() == 1) {
        // IF IS VALID IS ADDED TO LIST OF ROUTES
        Route r = new Route(a1, a2);
        routes.add(r);
      }
    }

    //TEST INPUTS
    System.out.println(calculateDistance("ABC"));
    System.out.println(calculateDistance("AD"));
    System.out.println(calculateDistance("ADC"));
    System.out.println(calculateDistance("AEBCD"));
    System.out.println(calculateDistance("AED"));
  }

  static String calculateDistance(String way) {

    //CHECK IF THE ENTERED ROUTE IS A VALID ROUTE (ONLY LETTERS)
    if (way.chars().allMatch(Character::isLetter)) {
      int index = 0;
      int distance = 0;
      int cont = 0;

      //SPLIT THE DIFFERENT PARTS OF THE ROUTE
      List<String> wayPoints = new ArrayList<>(way.length() - 1);
      for (int i = 0; i < way.length() - 1; i++) {
        wayPoints.add(way.substring(index, index + 2));
        index++;
      }
      //CHECK IF ALL PARTS ARE IN THE MAIN LIST OF ROUTES
      for (Route route : routes) {
        for (String wayPoint : wayPoints) {
          if (route.getRoute().equals(wayPoint)) {
            distance += route.getDistance();
            cont++;
          }
        }
      }
      //IF THE NUMBER OF PARTS FOUNDED DOESN'T MATCH THE TOTAL PARTS OF A ROUTE
      //ITS AN INCOMPLETE ROUTE AND RETURN NO SUCH ROUTE, ELSE RETURN THE DISTANCE
      return (way.length() - 1 != cont) ? "NO SUCH ROUTE" : Integer.toString(distance);
    }
    // IF IT'S NOT VALID RETURN THIS MSG
    else {
      return "INVALID TYPE OF ROUTE";
    }
  }
}
