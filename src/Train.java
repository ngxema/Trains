import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Train {

    private static final String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private static final HashMap<String, Integer> routes = new HashMap<>();


    /**
     *  Method to initialize all known routes
     */
    public static void getRoutes() {

        String[] routeVector = graph.split(", ");

        for (String itinerary : routeVector) {

            String path = itinerary.substring(0, itinerary.length() - 1);
            int distance = Integer.parseInt(itinerary.substring(itinerary.length() - 1));

            if (path.chars().allMatch(Character::isLetter) && path.length() == 2
                    && Integer.toString(distance).length() == 1) {

                routes.put(path, distance);
            }
        }
    }


    /**
     * Method to get the total distance of a path
     * @param path route to calculate
     * @return total distance
     */
    public static String calculateDistance(String path) {

        if (path != null && path.length() != 0) {

            List<String> segments = getSegments(path);
            int totalDistance = 0;

            for (String segment : segments) {

                if (segment.chars().allMatch(Character::isLetter)) {

                    if (routes.containsKey(segment)){

                        totalDistance += routes.get(segment);
                    }
                    else {
                        return "NO SUCH ROUTE";
                    }
                } else {
                    return "INVALID ROUTE";
                }
            }

            return Integer.toString(totalDistance);
        }
        return "NO ROUTE PROVIDED";
    }


    /**
     * Method for dividing the route to be calculated into segments
     * @param path route to calculate
     * @return route segments
     */
    private static List<String> getSegments(String path) {

        String[] fullPath = path.split("-");
        List<String> segments = new ArrayList<>();

        for (int i = 1; i < fullPath.length; i++) {

            segments.add(fullPath[i - 1] + fullPath[i]);
        }

        return segments;
    }

}
