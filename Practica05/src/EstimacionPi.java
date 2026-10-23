public class EstimacionPi {
  public static void main (String[] args) {
    
    //se declara la variable del numero de dardos que queremos y las variables
    //donde se almacenaran el numero de dardos lanzados y de los que caen dentro.
    int totalDardos = 1000000;
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
      System.out.printf("%.6f", estimacionPi);
    
  }
}
