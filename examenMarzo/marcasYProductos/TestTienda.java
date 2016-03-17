package pgn.examenMarzo.marcasYProductos;

import java.util.regex.Pattern;

/**
 * 
 * @author alvaro
 * @version 1.0
 */

import pgn.examenMarzo.utiles.Menu;
import pgn.examenMarzo.utiles.Teclado;

public class TestTienda {
	static private Menu menu = null;
	static Tienda tienda;

	private static Menu menuMarcas = new Menu("Marcas de los componentes", Marca.SONY.generarOpcionesMenu());
	private static Menu menuComponentes = new Menu("Componentes", Componente.DISCO_DURO.generarOpcionesMenu());

	public static void main(String[] args) throws Exception {
		tienda = new Tienda("GC Componentes");
		int opcion = 0;
		String[] opciones = { "Alta de un producto", "Baja de un producto", "Mostrar un producto", "Mostrar tienda",
				"Mostrar productos de una marca", "Incrementar 10% precio de los productos con precio < 100",
				"Dar de alta lista de productos", "Salir de la tienda" };
		menu = new Menu("-------Tienda de componentes-------", opciones);

		do {
			opcion = menu.gestionar();

			switch (opcion) {
			case 1:
				altaProducto();
				break;
			case 2:
				bajaProducto();
				break;
			case 3:
				mostrarProducto();
				break;
			case 4:
				mostrarTienda();
				break;
			case 5:
				mostrarProductoMarca();
				break;
			case 6:
				incrementarPrecio();
				break;
			case 7:
				darDeAlta();
				break;
			case 8:
				System.out.println("Saliendo del programa...");
				break;
			}
		} while (opcion != 8);
	}

	/**
	 * METODO QUE SIRVE PARA DAR DE ALTA UN PRODUCTO
	 * 
	 */

	private static void darDeAlta() {
		try {
			annadirProductos();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "No se ha podido añadir el componente en la tienda");
		}
	}

	/**
	 * METODO QUE SIRVE PARA AÑADIR PRODUCTOS
	 * 
	 * @throws Exception
	 */

	private static void annadirProductos() throws Exception {
		tienda.annadir("SONY", "DISCO_DURO", 240.5, "El mejor del mundo mundial");
		System.out.println("Componente añadido con éxito");
		tienda.annadir("INTELCORE", "PROCESADOR", 175, "Intel Core i5-4460 3.2Ghz Box");
		System.out.println("Componente añadido con éxito");
		tienda.annadir("SEAGATE", "DISCO_DURO", 45.5, "Seagate Barracuda 7200.14 1TB SATA3");
		System.out.println("Componente añadido con éxito");
		tienda.annadir("SAMSUNG", "DISCO_DURO", 82, "Samsung 850 Evo SSD Series 250GBSATA3");
		System.out.println("Componente añadido con éxito");
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR PRODUCTOS DE UNA MARCA
	 * 
	 */

	private static void mostrarProductoMarca() {
		try {
			tienda.mostrarProductoMarca(Teclado.leerCadena("Introduce marca (EN MAYUSCULAS): "));
		} catch (ProductoNoExisteException e) {
			System.out.println(e.getMessage() + "No se ha podido mostrar el componente en la tienda");
		}
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR UN PRODUCTO
	 * 
	 */

	private static void mostrarProducto() {
		try {
			tienda.mostrarProducto(Teclado.leerCadena("Introduce identificador: "));
		} catch (ProductoNoExisteException e) {
			System.out.println(e.getMessage() + "No se ha podido mostrar el componente en la tienda");
		}
	}

	/**
	 * METODO QUE SIRVE PARA DAR DE BAJA UN PRODUCTO
	 * 
	 */

	private static void bajaProducto() {
		try {
			tienda.eliminar(Teclado.leerCadena("Introduce identificador: "));
			System.out.println("Componente eliminado con éxito");
		} catch (ProductoNoExisteException e) {
			System.out.println(e.getMessage() + "No se ha podido eliminar el componente en la tienda");
		}
	}

	/**
	 * METODO QUE SIRVE PARA DAR DE ALTA UN PRODUCTO
	 * 
	 * @throws ProductoYaExisteException
	 * 
	 */

	private static void altaProducto() throws ProductoYaExisteException {
		try {
			tienda.annadir(String.valueOf(pedirMarca()), String.valueOf(pedirComponente()), elegirPrecio(),
					elegirDescriptor());
			System.out.println("Componente añadido con éxito");
		} catch (ProductoYaExisteException e) {
			System.out.println(e.getMessage() + "No se ha podido añadir el componente en la tienda");
		}
	}

	/**
	 * METODO QUE SIRVE PARA PEDIR MARCA
	 * 
	 * @return
	 */

//	private static Marca pedirMarca() {
//		int opcion = menuMarcas.gestionar();
//		Marca[] arrMarcas = Marca.SONY.getValues();
//		if (opcion == arrMarcas.length + 1)
//			return null;
//		return arrMarcas[opcion - 1];
//	}
	
	private static String pedirMarca() {
		int opcion = menuMarcas.gestionar();
		String[] arrMarcas = Marca.SONY.getMarcas();
		if (opcion == arrMarcas.length + 1)
			return null;
		return arrMarcas[opcion - 1];
	}

	/**
	 * METODO QUE SIRVE PARA PEDIR COMPONENTE
	 * 
	 * @return
	 */

	private static String pedirComponente() {
		int opcion = menuComponentes.gestionar();
		String[] arrComponentes = Componente.DISCO_DURO.getComponentes();
		if (opcion == arrComponentes.length + 1)
			return null;
		return arrComponentes[opcion - 1];
	}

	/**
	 * METODO QUE SIRVE PARA MOSTRAR TODOS LOS PRODUCTOS
	 * 
	 * @param tienda
	 */

	private static void mostrarTienda() {
		System.out.println(tienda.mostrarProductos());
	}

	/**
	 * METODO QUE SIRVE PARA ELEGIR PRECIO
	 * 
	 * @return
	 */

	private static double elegirPrecio() {
		double precio = 0;
		do {
			precio = Teclado.leerDecimal("Introduce un precio positivo. ");
		} while (precio <= 0);

		return precio;
	}

	/**
	 * METODO QUE SIRVE PARA ELEGIR UN DESCRIPTOR
	 * 
	 * @return
	 */

	private static String elegirDescriptor() {
		boolean b;
		String descriptor = "";
		do {
			descriptor = Teclado.leerCadena("Introduce un descriptor de más de tres palabras: ");
			b = Pattern.matches("^([a-zA-ZáéíóúñÁÉÍÓÚÑ]+\\s){2,}([a-zA-ZáéíóúñÁÉÍÓÚÑ]+)$", descriptor);
		} while (!b);
		return descriptor;
	}

	private static void incrementarPrecio() {
		tienda.incrementarPrecio();
	}
}
