public class PrecisionPi {
    public static void main(String[] args) {
        double tolerancia = 0.001;
        double aproxPi = 0;
        double error = Math.abs((aproxPi - Math.PI));

        // variables donde se almacena el numero de dardos lanzados y los dardos dentro.
        int dardosLanzados = 0;
        int dardosDentro = 0;

        // en un bucle generamos los dardos y contamos cuantos caen dentro del circulo
        while (error >= tolerancia) {
            double coordEnX = Math.random();
            double coordEnY = Math.random();

            // funcion para calcular distancias
            double distancia_centro = Math.sqrt(Math.pow(coordEnX, 2) + Math.pow(coordEnY, 2));

            // si cae dentro se actualiza el contador de dardos dentro
            if (distancia_centro <= 1.0) {
                dardosDentro++;
            }

            // haya caido dentro o no, se aumenta el numero de dardos lanzados.
            dardosLanzados++;

            aproxPi = 4.0 * dardosDentro / dardosLanzados;

            // se actualiza la variable de control del ciclo while
            error = Math.abs((aproxPi - Math.PI));

        }

        // imprimimos el resultado.
        System.out.printf("%.6f%n", aproxPi);
        System.out.println("Total de dardos necesarios: " + dardosLanzados);
    }
}
