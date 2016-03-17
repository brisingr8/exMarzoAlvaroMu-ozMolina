package pgn.examenMarzo.marcasYProductos;

import java.util.ArrayList;

public class Tienda {
	private String nombre;

	Tienda(String nombre) {
		setNombre(nombre);
	}

	// CREAMOS ARRAYLIST
	static private ArrayList<Producto> productos = new ArrayList<Producto>();

	public static ArrayList<Producto> getProductos() {
		return productos;
	}

	public static void setProductos(ArrayList<Producto> productos) {
		Tienda.productos = productos;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean buscarProducto(String marca) {
		for (int i = 0; i < productos.size(); i++) {
			if (marca.equals(productos.get(i).getIdentificador())) {
				return true;
			}
		}
		return false;
	}

	public void crearProducto(Producto producto) {
		productos.add(producto);
	}

	// public String mostrarProducto(int identificador) {
	// String string = "";
	//
	// for (int i = 0; i < productos.size(); i++) {
	// if(identificador==productos.get(i).getIdentificador()){
	// string = productos.get(i).toString();
	// }
	// }
	// return string;
	// }

	public String mostrarProductos() {
		String string = "";
		if (productos.isEmpty()) {
			string = string + "La lista está vacía. ";
			return string;
		} else {
			for (int i = 0; i < productos.size(); i++) {
				string = string + "\n" + productos.get(i);
			}
			return string;
		}
	}

	public static void incrementarPrecio() {
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getPrecio() < 100) {
				productos.get(i).setPrecio(productos.get(i).getPrecio() + productos.get(i).getPrecio() * 10 / 100);
			}
		}
	}

	void annadir(String marca, String componente, double precio, String descripcion) throws ProductoYaExisteException {
		Producto producto = new Producto(marca, componente, precio, descripcion);
		if (!productos.contains(producto))
			productos.add(producto);
		else
			throw new ProductoYaExisteException("El producto ya existe en la tienda. ");
	}

	public boolean eliminar(String identificador) throws ProductoNoExisteException {
		return productos.remove(new Producto(identificador));	
	}

	public boolean mostrarProducto(String identificador) throws ProductoNoExisteException {
		int cont=0;
		for(int i=0; i<productos.size(); i++){
			if(productos.get(i).getIdentificador().equals(identificador)){
				System.out.println(productos.get(i));
				cont++;
			}
		}
		if(cont==0){
			throw new ProductoNoExisteException("El producto no existe en la tienda. ");
			
		}
		return true;
	}

	public boolean mostrarProductoMarca(String marca) throws ProductoNoExisteException {
		int cont=0;
		for(int i=0; i<productos.size(); i++){
			if(productos.get(i).getMarca().equals(marca)){
				System.out.println(productos.get(i));
				cont++;
			}
		}
		if(cont==0){
			throw new ProductoNoExisteException("La marca no tiene productos en la tienda. ");
			
		}
		return true;		
	}
}
