/*
 * Cotizador del senor Pines : Calcula el interes simple de un prestamo,
 * el total a pagar y la mensualidad, a partir de los datos del cliente.
 */

import java.util.Scanner;

public class CabanaDelMisterio {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // ### Datos del cliente ###
    System.out.println("Ingresa el nombre del cliente");
    String nombreCliente = scanner.nextLine();

    // Clasificaciones: 'P' de Preferente; 'E' de Estandar; 'R' de Riesgoso.
    char clasificacionCliente;
    while (true) {
      System.out.println("Ingresa la clasificación del cliente (P, E o R)");
      clasificacionCliente = scanner.next().charAt(0);
      //Validación de la clasificación ingresada:
      if (clasificacionCliente != 'P' && clasificacionCliente != 'E' && clasificacionCliente != 'R') {
        System.out.println("Clasificacion invalida. Ingresa solo 'P', 'E' o 'R'");
      } else {
        break;
      }
    }

    // ### Datos del prestamo ###

    // Capital prestado.
    int capital;
    while (true) {
      System.out.println("Ingresa el capital a prestar: ");
      if (scanner.hasNextBigInteger()) { //se valida que sea entero
        if (scanner.hasNextInt()) { //se valida que quepa en los enteros
          capital = scanner.nextInt();
          if (capital > 0) { //se valida que sea mayor a cero
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

    double totalAPagarCompuesto = capital;
    double totalAPagarSimple = capital;

    // Tasa de interes anual
    double tasaAnual;
    while (true) {
      System.out.println("Ingresa la tasa de interes anual base\n");
      if (scanner.hasNextDouble()) { //se valida que la entrada sea un double
        tasaAnual = scanner.nextDouble(); // Corregido a nextDouble()
        if (tasaAnual > 0) { //se valida que sea mayor a cero
          break;
        } else { // Si el numero no es mayor a cero, se imprime la linea de abajo y vuelve a comenzar el while
          System.out.println("El número ingresado debe ser mayor a cero.\n");
        }
      } else { // Si el valor no es un numero, se imprime la linea de abajo y vuelve a comenzar el while
        System.out.println("El valor ingresado no es un número.\n");
        scanner.next(); // Limpia la entrada no válida
      }
    }

    //Se actualiza la tasa anual dependiendo de la clasificacion del cliente
    if (clasificacionCliente == 'P') {
      tasaAnual -= 2;
    } else if (clasificacionCliente == 'R') {
      tasaAnual += 3;
    }

    // Convertimos la tasa anual a tasa mensual
    double tasaMensual = (tasaAnual/100)/12;

    // Plazo en meses en los que se hará el pago.
    int plazoMeses;
    while (true) {
      System.out.println("Ingresa la cantidad de meses en los que se hará el pago:\n");
      if (scanner.hasNextBigInteger()) { //se valida que sea entero
        if (scanner.hasNextInt()) { //se valida que quepa en los enteros
          plazoMeses = scanner.nextInt();
          if (plazoMeses > 0) { //se valida que sea mayor a cero
            break;
          } else { // Si el numero no es mayor a cero, se imprime la linea de abajo y vuelve a comenzar el while
            System.out.println("El número ingresado debe ser mayor a cero.\n");
          }
        } else { // Si el numero no cabe en int, se imprime la linea de abajo y vuelve a comenzar el while
          System.out.println("El valor ingresado es muy grande. Debe ser menor a " + Integer.MAX_VALUE + "\n");
          scanner.next(); // Limpia la entrada no válida
        }
      } else { // Si el valor no es un numero, se imprime la linea de abajo y vuelve a comenzar el while
        System.out.println("El valor ingresado no es un número entero.\n");
        scanner.next(); // Limpia la entrada no válida
      }
    }

    // ### Menú de operaciones ###
    int opcion = 0;
    int contadorErrores = 0;
    int contadorOperaciones = 0;

    char continuarOperaciones;

    do {
      boolean salirPorLimites = false;

      while (true) {
        if (contadorErrores < 3 && contadorOperaciones < 5) { // Se valida que llevemos menos de 5 errores
          System.out.println("""
            > Las operaciones disponibles son
            1) Cotizar con interes simple.
            2) Cotizar con interes compuesto.
            3) Comparar interes simple y compuesto.
            4) Cambiar el capital del prestamo.
            0) Salir.
            > Por favor, elige una opción :
          """);
          if (scanner.hasNextInt()) { //se valida que sea entero
            opcion = scanner.nextInt();
            if (opcion >= 0 && opcion <= 4) { //se valida que corresponda a una de las 5 opciones
              contadorOperaciones++;
              break;
            } else { // Si el numero no está en rango
              System.out.println("El numero ingresado debe corresponder al numero de opcion a realizar, entre 0 y 4\n");
              contadorErrores++;
            }
          } else { // Si el valor no es un numero
            System.out.println("Debes ingresar el numero correspondiente a la opcion a realizar, entre 0 y 4\n");
            contadorErrores++;
            scanner.next(); // Limpia la entrada no válida
          }
        } else if (contadorErrores == 3) { // Si llevamos 3 errores, se imprime el resumen y se termina
          System.out.printf("""
            Nombre del cliente: %s
            Numero de operaciones realizadas: %d
            Numero de errores cometidos: %d
            Capital con el que terminó el préstamo: %d
          %n""", nombreCliente, contadorOperaciones, contadorErrores, capital);
          System.out.println("Has llegado al límite de errores.");
          salirPorLimites = true;
          break;
        } else {
          System.out.printf("""
            Nombre del cliente: %s
            Numero de operaciones realizadas: %d
            Numero de errores cometidos: %d
            Capital con el que terminó el préstamo: %d
          %n""", nombreCliente, contadorOperaciones, contadorErrores, capital);
          System.out.println("Has llegado al límite de operaciones.");
          break;
        }
      }
      if (salirPorLimites || opcion == 0) {
      break;
      }

    // ### Realizamos la opcion que solicito el usuario ###

    //El plazo del crédito en años, lo necesitaremos así para calcular los intereses.
    double plazoAnios = plazoMeses / 12.0;

    //Inicia bucle de operaciones a realizar
    switch (opcion) {
      case 1:
        // Interes simple = capital * (tasa / 100) * tiempo en años.
        double interesSimple = capital * (tasaAnual / 100) * plazoAnios;

        // El pago en total.
        totalAPagarSimple = capital + interesSimple;

        System.out.printf("""
          --- Opción 1: Interés simple ---
          Nombre del cliente: %s
          Tipo de cliente: %c
          Capital del prestamo: %d
          Tasa anual: %.2f
          Plazo en meses: %d
          --------------------------------
          Interés simple: %.2f
          Total a pagar: %.2f
          --------------------------------

        """, nombreCliente, clasificacionCliente, capital, tasaAnual, plazoMeses, interesSimple, totalAPagarSimple);
      break;

      case 2:
        //Total a pagar con interes compuesto
        totalAPagarCompuesto = capital * Math.pow((1 + tasaMensual), 21);

        //Interes total a pagar durante todo el plazo
        double interesCompuesto = totalAPagarCompuesto - capital;

        System.out.printf("""
          --- Opción 2: Interés compuesto ---
          Nombre del cliente: %s
          Tipo de cliente: %c
          Capital del prestamo: %d
          Tasa anual: %.2f
          Plazo en meses: %d
          --------------------------------
          Interés compuesto: %.2f
          Total a pagar: %.2f
          --------------------------------

        """, nombreCliente, clasificacionCliente, capital, tasaAnual, plazoMeses, interesCompuesto, totalAPagarCompuesto);
        // Usamos una variable temporal para imprimir el saldo mensual sin arruinar el total
        double saldoMensual = capital;
        for (int m = 1; m<= plazoMeses; m++) {
          saldoMensual = saldoMensual * (1 + tasaMensual);
          System.out.printf("En el mes %d se tiene un saldo de %.1f %n", m, saldoMensual);
        }
      break;
      case 3:
        // Interes simple total a pagar durante todo el plazo
        interesSimple = capital * (tasaAnual / 100) * plazoAnios;
        
        totalAPagarCompuesto = capital * Math.pow((1 + tasaMensual), plazoMeses);

        interesCompuesto = totalAPagarCompuesto - capital;

        System.out.printf("""
          --- Opción 3: Comparar intereses ---
          Nombre del cliente: %s
          Tipo de cliente: %c
          Capital del prestamo: %d
          Tasa anual: %.2f
          Plazo en meses: %d
          -----------------------------------
          Interés simple: %.2f
          Interés compuesto: %.2f
          La diferencia entre ellos es de %.2f
          -----------------------------------

        """, nombreCliente, clasificacionCliente, capital, tasaAnual, plazoMeses, interesCompuesto, interesSimple, interesCompuesto - interesSimple);
      break;

      case 4:
        while (true) {
          System.out.println("Ingresa el nuevo capital a prestar: \n");
          if (scanner.hasNextBigInteger()) { //se valida que sea entero
            if (scanner.hasNextInt()) { //se valida que quepa en los enteros
              capital = scanner.nextInt();
              if (capital > 0) { //se valida que sea mayor a cero
                break;
              } else { // Si el numero no es mayor a cero, se imprime la linea de abajo y vuelve a comenzar el while
                System.out.println("El número ingresado debe ser mayor a cero.\n");
              }
            } else { // Si el numero no cabe en int, se imprime la linea de abajo y vuelve a comenzar el while
              System.out.println("El valor ingresado es muy grande. Debe ser menor a " + Integer.MAX_VALUE + "\n");
              scanner.next(); // Limpia la entrada no válida
            }
          } else { // Si el valor no es un numero, se imprime la linea de abajo y vuelve a comenzar el while
            System.out.println("El valor ingresado no es un número entero.\n");
            scanner.next(); // Limpia la entrada no válida
          }
        }
        // Interes simple total a pagar durante todo el plazo
        interesSimple = capital * (tasaAnual / 100) * plazoAnios;
        // Total a pagar con interes simple
        totalAPagarSimple = capital + interesSimple;

        //Interes compuesto total a pagar durante todo el plazo
        interesCompuesto = totalAPagarCompuesto - capital;
        //Total a pagar con interes compuesto
        totalAPagarCompuesto = capital * Math.pow((1 + tasaMensual), plazoMeses);

        System.out.printf("""
          Interés simple: %.2f
          Total con interés simple: %.2f
          Interés compuesto: %.2f
          Total con interés compuesto: %.2f
          Diferencia: %.2f

        """, interesSimple, totalAPagarSimple, interesCompuesto, totalAPagarCompuesto, interesCompuesto - interesSimple);
      break;

      default:
      break;
    }

    System.out.println("\n¿Deseas realizar otra operación? (Ingresa 'S' para continuar, cualquier otra tecla para salir)");
    continuarOperaciones = scanner.next().charAt(0);

    } while (continuarOperaciones == 'S' || continuarOperaciones == 's'); // Se cierra el ciclo do-while principal

    System.out.println("¡Hasta luego!");
    scanner.close();
  }
}
