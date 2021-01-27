import java.util.ArrayList;
import java.util.List;

public class Corrections {

    private static final String graph = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    private static List<Route> routes = new ArrayList<>();
    //GENERÉ UNA LISTA DE RUTAS (CLASE QUE DEFINÍ) EN LUGAR DE UN HASHMAP COMO TENGO AHORA.
    //USAR UNA LISTA DE OBJETOS COMPLICA UN POCO LA TAREA OBTENER EL VALOR DE UN ELEMENTO ESPECIFICO YA QUE TIENES
    //QUE RECORRER TODA LA LISTA E IR BUSCANDO EL VALOR QUE QUIERES DENTRO DEL OBJETO RUTA


    public static void main(String[] args) {

        //USÉ EL MÉTODO MAIN PARA INICIALIZAR Y TESTEAR LA CLASE, COSA QUE NO SE DEBE HACER EN ESTE LUGAR:

        String[] routeVector = graph.split(", ");

        for (String route : routeVector) {
            String a1 = route.substring(0, route.length() - 1);
            int a2 = Integer.parseInt(route.substring(route.length() - 1));

            if (a1.chars().allMatch(Character::isLetter) && a1.length() == 2
                    && Integer.toString(a2).length() == 1) {

                Route r = new Route(a1, a2);
                routes.add(r);
            }
        }

        //TODAS ESTAS VALIDACIONES DEBERIAN IR A UNA CLASE DE TESTS
        System.out.println(calculateDistance("ABC"));
        System.out.println(calculateDistance("AD"));
        System.out.println(calculateDistance("ADC"));
        System.out.println(calculateDistance("AEBCD"));
        System.out.println(calculateDistance("AED"));
    }

    static String calculateDistance(String way) {

        if (way.chars().allMatch(Character::isLetter)) {
            int index = 0;
            int distance = 0;
            int cont = 0;

            //AQUI OBTENIAMOS LOS SEGMENTOS DE LA RUTA DE UNA FORMA UN POCO REBUSCADA YA QUE
            //OMITIMOS LOS GUIONES PENSADO QUE IBA A SIMPLIFICAR EL ESFUERZO
            List<String> wayPoints = new ArrayList<>(way.length() - 1);
            for (int i = 0; i < way.length() - 1; i++) {
                wayPoints.add(way.substring(index, index + 2));
                index++;
            }


            //EN ESTA PARTE SE RECORRÍA SIEMPRE DE PRINCIPIO A FIN EL ARRAY CON TODAS LAS RUTAS CONOCIDAS
            //COSA QUE NO ES MUY OPTIMO SI SE DISPONE DE MUCHAS RUTAS YA QUE PUEDE HABER ENCONTRADO LAS
            //PERTINENTES Y SEGUIRÁ HACIENDO COMPROBACIONES HASTA EL FINAL

            //TAMBIEN SE USA LA VARIABLE CONT PARA VERIFICAR DE MANERA NO MUY CORRECTA QUE LA RUTA ENCONTRADA
            //COINCIDE PLENAMENTE CON LA RUTA QUE SE HA PASADO POR PARAMETRO
            for (Route route : routes) {
                for (String wayPoint : wayPoints) {
                    if (route.getRoute().equals(wayPoint)) {
                        distance += route.getDistance();
                        cont++;
                    }
                }
            }

            //FINALMENTE SE DEVOLVIA LA DISTANCIA DE LA RUTA O EN CASO DE NO ESTAR COMPLETA SE DEVOLVIA QUE NO
            //EXISTE. USAR UN HASHMAP SIMPLIFICA MUCHO EL TRABAJO Y ES MAS PRACTICO QUE USAR UNA CLASE
            return (way.length() - 1 != cont) ? "NO SUCH ROUTE" : Integer.toString(distance);
        } else {
            return "INVALID TYPE OF ROUTE";
        }
    }
}