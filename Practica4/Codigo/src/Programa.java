public class Programa{	
	public static void main(String[] args) {
	
  //descripción del producto
	String producto = "Laptop para la carrera";
  //Precio del producto
	int precio = 15000;
  //descuento que se le aplicará al producto
	int descuento = 3000;
  //plazo en meses en los que se pagará el producto
	double meses = 18.0;

  //se imprime el título de los datos a presentar: en este caso, la ficha de compra.
	System.out.println("=== Ficha de compra ===");
  //imprimimos el nombre del producto
	System.out.println("- Producto : " + producto);	
  //imprimimos el precio con el descuento aplicado
	System.out.println("- Precio con descuento : " + (precio - descuento));
  //imprimimos el número de años en los que se debe pagar el producto
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
  //imprimimos la cantidad mensual a pagar por el cliente
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
  //anunciamos el fin de la ficha de compra.
	System.out.println("=== Fin de la ficha ===");

	}


