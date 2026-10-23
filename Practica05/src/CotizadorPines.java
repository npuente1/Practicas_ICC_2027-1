/*
 * Cotizador del senor Pines : Calcula el interes simple de un prestamo,
 * el total a pagar y la mensualidad, a partir de los datos del cliente.
 */
public class CotizadorPines {
    public static void main(String[] args) {

//errores posibles
        int codigoError = 0;
        int clasifClienteInvalid = 1;
        int plazoInvalid = 2;
        int capitalInvalid = 3;

// ### Datos del cliente ###
        String nombreCliente = "Robbie Valentino";

  // Clasificaciones: 'P' de Preferente; 'E' de Estandar; 'R' de Riesgoso.
        char clasificacionCliente = 'E';

// ### Datos del prestamo ###

  // Monto prestado.
        double capital = 12899.0;
        if (capital < 0) {
          codigoError = capitalInvalid;
        }
        double totalAPagarCompuesto = capital;
        double totalAPagarSimple = capital;

  // Porcentaje que se cobra por año, dependiendo de la clasificacion del cliente
        double tasaAnual = 15.0;
        if (clasificacionCliente == 'P') {
          tasaAnual -= 2;
        } else if (clasificacionCliente == 'R') {
          tasaAnual += 3;
        } else if (clasificacionCliente == 'E') {
        } else {
          codigoError = clasifClienteInvalid;
        }
        
        double tasaMensual = (tasaAnual/100)/12;

  // Plazo en meses en los que se hará el pago.
        int plazoMeses = 21;
        if (plazoMeses < 0) {
          codigoError = plazoInvalid;
        }

// ### Calculos ###
    // Calculamos el plazo en anios, dividiendo el plazo en meses entre 12
        double plazoAnios = plazoMeses / 12.0;

  //Total a pagar con interes compuesto (con bucle for)
        if (codigoError == 0) {
          for (int m = 1; m<= plazoMeses; m++) {
            totalAPagarCompuesto = totalAPagarCompuesto * (1 + tasaMensual);
            System.out.printf("En el mes %d se tiene un saldo de %.1f %n", m, totalAPagarCompuesto);
          }
        }

  //Total a pagar con interes compuesto
        totalAPagarCompuesto = capital * Math.pow((1 + tasaMensual), 21);

  //Interes total a pagar durante todo el plazo
        double interesCompuesto = totalAPagarCompuesto - capital;

  // Interes simple = capital * (tasa / 100) * tiempo en años.
        double interesSimple = capital * (tasaAnual / 100) * plazoAnios;

  // El pago en total.
       totalAPagarSimple = capital + interesSimple;

  // La mensualidad reparte el total entre los meses del plazo.
        double mensualidad = totalAPagarCompuesto / plazoMeses;

  // Se imprimen los errores en los datos ingresados. Si no hay, se imprimen los datos.
          switch (codigoError) {
            case 1:
              System.out.println("Clasificación de cliente inválida. Ingresar P, E o R");
              break;
            case 2:
              System.out.println("El plazo del crédito ingresado es inválido. Ingresa un valor numérico positivo.");
              break;
            case 3:
              System.out.println("El monto a prestar ingresado es inválido. Ingresa un valor numérico positivo.");
              break;
            default:
	            System.out.println("--- Datos del cliente ---");
              System.out.printf("Cliente: %s%n", nombreCliente);
              System.out.printf("Clasificacion: %c%n", clasificacionCliente);
              System.out.println("\n--- Datos del prestamo ---");
              System.out.printf("Capital: $%.2f%n", capital);
              System.out.printf("Tasa anual: %.2f%%%n", tasaAnual);
              System.out.printf("Plazo: %d meses (%.2f anios)%n", plazoMeses, plazoAnios);
              System.out.println("\n--- Resultado ---");
              System.out.printf("Interes simple total: $%.2f%n", interesSimple);
              System.out.printf("Interes compuesto total: $%.2f%n", interesCompuesto);
              System.out.printf("Total a pagar con interés simple: $%.2f%n", totalAPagarSimple);
              System.out.printf("Total a pagar con interés compuesto: $%.2f%n", totalAPagarCompuesto);
              System.out.printf("Mensualidad: $%.2f%n", mensualidad);
              break;
          
        }
    }
}
