package pgn.examenMarzo.marcasYProductos;

public enum Marca {
	SONY("SN"), SEAGATE("SG"), INTELCORE("IN"), SAMSUNG("SM");

	private String marca;

	private Marca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	// ALMACENA TODOS LAS MARCAS POSIBLES
	private static final Marca[] VALUES = values();

	// GENERA LAS OPCIONES DEL MENU INCLUYENDO SALIR
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Marca marca : VALUES) {
			opcionesMenu[i++] = marca.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	 // DEVUELVE VALUES
//	 public Marca[] getValues() {
//	 return VALUES;
//	 }

	public String[] getMarcas() {
		String[] marcas = new String[VALUES.length + 1];
		int i = 0;
		for (Marca marca : VALUES) {
			marcas[i++] = marca.getMarca();
		}
		marcas[i] = "Salir";
		return marcas;
	}

	// public Marca[] getNames(){
	// return VALUES;
	// }
}
