import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Before
    public void prepareRoutes() {

        Train.getRoutes();
    }

    @Test
    public void testRoutes() {

        String distance = Train.calculateDistance("A-B-C");
        assertEquals("9", distance);
        System.out.println(distance);

        distance = Train.calculateDistance("A-D");
        assertEquals("5", distance);
        System.out.println(distance);

        distance = Train.calculateDistance("A-D-C");
        assertEquals("13", distance);
        System.out.println(distance);

        distance = Train.calculateDistance("A-E-B-C-D");
        assertEquals("22", distance);
        System.out.println(distance);

        distance = Train.calculateDistance("A-E-D");
        assertEquals("NO SUCH ROUTE", distance);
        System.out.println(distance);
    }

}