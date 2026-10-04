public class ProgramaNuevo{	
	public static void main(String[] args) {
	
  //descripción del producto
	String producto = "Laptop para la carrera";
  //Precio del producto
	int precio = 15000;
  //descuento que se le aplicará al producto
	int descuento = 3000;
  //plazo en meses en los que se pagará el producto
	double meses = 18.0;

  //Imprimimos todos los datos, concatenándolos y añadiendo el formato de dos decimales para el pago mensual. El argumento se indica al final de la línea separado con coma.
  System.out.printf("=== Ficha de compra ===" + "\n- Producto: " + producto + "n- Precio con descuento: " + (precio - descuento) + "\n- Plazo en anios: " + (meses / 12.0) + "\n- Pago mensual : %.2f%n" + "=== Fin de la ficha ===", ((precio - descuento) / meses) );
	}
}
