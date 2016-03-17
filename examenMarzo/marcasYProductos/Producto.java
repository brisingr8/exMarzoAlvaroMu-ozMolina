
package pgn.examenMarzo.marcasYProductos;

public class Producto {
	private String marca;
	private String componente;
	private double precio;
	private String descriptor;
	private String identificador;
	private int contador;
	static private int cont = 0;

	Producto(String marca, String componente, double precio, String descriptor) {
		super();
		setMarca(marca);
		setComponente(componente);
		setPrecio(precio);
		setDescriptor(descriptor);
		setContador();
		setIdentificador();
	}

	Producto(String identificador) {
		this.identificador = identificador;
	}

	private void setIdentificador() {
		this.identificador = String.valueOf(getMarca()) + "-" + getComponente() + "-" + getContador();
	}

	public String getIdentificador() {
		return identificador;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	private void setComponente(String componente) {
		this.componente = componente;
	}

	void setPrecio(double precio) {
		this.precio = precio;
	}

	private void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getMarca() {
		return marca;
	}

	public String getComponente() {
		return componente;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDescriptor() {
		return descriptor;
	}

	private void setContador() {
		this.contador = ++cont;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	public int getContador() {
		return contador;
	}

	public String toString() {
		return this.identificador + ", " + marca + ", " + componente + ", " + precio + ", " + descriptor;
	}
}
