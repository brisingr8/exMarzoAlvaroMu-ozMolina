package pgn.examenMarzo.marcasYProductos;

public enum Componente {

	DISCO_DURO("DD"), PROCESADOR("PR"), RAM("MR"), FUENTE("FA");

	private String componente;

	private Componente(String componente) {
		this.componente = componente;
	}

	public String getComponente() {
		return componente;
	}

	// ALMACENA TODOS LOS COMPONENTES POSIBLES
	private static final Componente[] VALUES = values();

	// GENERA LAS OPCIONES DEL MENU INCLUYENDO SALIR
	public String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Componente componente : VALUES) {
			opcionesMenu[i++] = componente.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	// // DEVUELVE VALUES
	// public Componente[] getValues() {
	// return VALUES;
	// }

	public String[] getComponentes() {
		String[] componentes = new String[VALUES.length + 1];
		int i = 0;
		for (Componente componente : VALUES) {
			componentes[i++] = componente.getComponente();
		}
		componentes[i] = "Salir";
		return componentes;
	}
}
