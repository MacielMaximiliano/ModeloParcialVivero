package ar.edu.unlam.pb1.vivero;

import java.util.Objects;

public abstract class Planta {

	private int codigo;
	private String nombre;
	private int stock;
	private Double precioBase;


	public Planta(Integer codigo , String nombre, double precio, int stock) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precio;
	}

	public Double getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int vendidas) {
		this.stock -= vendidas;
	}

	/*
	 * Cada Planta tiene un valor denominadado ganancia y este se debe
	 * multiplicar por el precio base para el calculo del precio final. Considerar ademas la/s
	 * interfaces aplicadas a cada tipo de planta, las cuales modifican el precio final de la planta
	 */

	public abstract Double obtenerPrecio();

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Planta other = (Planta) obj;
		return codigo == other.codigo;
	}



	
	
	
	

}
