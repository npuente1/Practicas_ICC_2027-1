import java.util.Scanner;

public class BinarioInteractivo {
  public static void main (String[] args) {

    Scanner scanner = new Scanner (System.in);
    int numero = 0;
    int numeroOriginal = 0;

    //Pedimos el numero a convertir hasta obtener un numero valido
    while (true) {
      System.out.println("Ingresa un número entero para convertir a binario:");
      if (scanner.hasNextBigInteger()) { //se valida que sea entero
        if (scanner.hasNextInt()) { //se valida que quepa en los enteros
          numero = scanner.nextInt();
          if (numero >= 0) { //se valida que no sea negativo
            numeroOriginal = numero; //guardamos el valor original para imprimirlo al final
            break;
          } else { // Si el numero es negativo, se imprime la linea de abajo y vuelve a comenzar el while
            System.out.println("El número ingresado no puede ser negativo. Inténtalo nuevamente.");
          }
        } else { // Si el numero no cabe en int, se imprime la linea de abajo y vuelve a comenzar el while
          System.out.println("El valor ingresado es muy grande. Debe ser menor o igual a " + Integer.MAX_VALUE);
          scanner.next(); // Limpia la entrada no válida
        }
      } else { // Si el valor no es un numero, se imprime la linea de abajo y vuelve a comenzar el while
        System.out.println("El valor ingresado no es un número entero. Inténtalo nuevamente.");
        scanner.next(); // Limpia la entrada no válida
      }
    }

    //se declara la variable donde se almacenara el resultado
    String binario = "";

    //Si el numero proporcionado es 0, el resultado es 0
    if (numero == 0) {
      binario = "0";
    } else {
      //en el while obtenemos el residuo y armamos el string de derecha a izquierda
      //y seguimos dividiendo el numero entre 2 hasta que llegue a 0.
      while (numero > 0) {
        int residuo = numero % 2;
        //se concatena el residuo a la izquierda de lo que ya teniamos en la cadena
        binario = residuo + binario;
        numero = numero / 2;
      }
    }

    //se imprime el resultado final
    System.out.println("El numero " + numeroOriginal + " en binario es: " + binario);

  }
}
