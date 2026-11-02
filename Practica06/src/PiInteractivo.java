import java.util.Scanner;
public class PiInteractivo {
  public static void main (String[] args) {
   
    Scanner scanner = new Scanner (System.in);
    int totalDardos = 0;

    //Pedimos el numero de dardos a lanzar hasta obtener un numero valido
    while (true) {
      System.out.println("Ingresa el número de dardos a lanzar:");
      if (scanner.hasNextBigInteger()) { //se valida que sea entero
        if (scanner.hasNextInt()) { //se valida que quepa en los enteros
          totalDardos = scanner.nextInt();
          if (totalDardos > 0) { //se valida que sea mayor a cero
            break;
          } else { // Si el numero no es mayor a cero, se imprime la linea de abajo y vuelve a comenzar el while
            System.out.println("El número ingresado debe ser mayor a cero.");
          }
        } else { // Si el numero no cabe en int, se imprime la linea de abajo y vuelve a comenzar el while
          System.out.println("El valor ingresado es muy grande. Debe ser menor a " + Integer.MAX_VALUE);
          scanner.next(); // Limpia la entrada no válida
        }
      } else { // Si el valor no es un numero, se imprime la linea de abajo y vuelve a comenzar el while
        System.out.println("El valor ingresado no es un número entero.");
        scanner.next(); // Limpia la entrada no válida
      }
    }

    //se declaran las variables donde se almacenaran el numero de dardos lanzados y de los que caen dentro.
    double dardosLanzados = 0;
    double dardosDentro = 0;

    //en el bucle generamos los dardos y  seguimos lanzando dardos hasta llegar
    //al numero de dardos deseados.
    while (dardosLanzados < totalDardos) {
      double coordenadaDardoX = Math.random();
      double coordenadaDardoY = Math.random();

      //Cuando el dardo cae dentro del circulo se aumenta el contador de dardos dentro.
      double distanciaDardo = Math.sqrt(Math.pow(coordenadaDardoX, 2) + Math.pow(coordenadaDardoY, 2));
      if (distanciaDardo <= 1.0) {
        dardosDentro ++;
      }

      //al final, sin importar si el dardo cae dentro o fuera, aumenta el total de dardos lanzados.
      dardosLanzados ++;
    }

    //se calcula e imprime la estimacion de pi usando el numero de dardos dentro del circulo y el total de dardos.
    double estimacionPi = 4 * (dardosDentro / totalDardos);
      System.out.printf("Pi estimado con el número de dardos indicado es: %.6f", estimacionPi);
    
  }
}
