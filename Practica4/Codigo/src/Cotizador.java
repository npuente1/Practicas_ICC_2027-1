public class Cotizador{
    public static void main (String [] args){

      //Declaramos las variables que usaremos
        int precioCliente1 = 1299;
        String cliente1 = "Robbie Valentino";
        char clasificacionCliente1 = 'E';
        double tasaAnual = 0.15;
        double plazo = 21.0 / 12;
        double plazoCliente1 = 21.0 / 12;

        //Usamos el precio del cliente1, la tasa anual y el plazo del crédito para calcular los intereses, el total y el número de mensualidades.
        double interes = (precioCliente1 * (tasaAnual) * plazoCliente1);
        double total = precioCliente1 + interes;
        double mensualidad = total / 21;

        //Se imprime toda la información solicitada por el señor Pines
        System.out.println(cliente1 + " " + clasificacionCliente1);
        System.out.printf("Debe un total de: %.2f%n" + "\nDe lo cual, solo los intereses suman: %.2f%n", total, interes);
        System.out.printf("La mensualidad es de: %.2f%n", mensualidad);

      }
  }
