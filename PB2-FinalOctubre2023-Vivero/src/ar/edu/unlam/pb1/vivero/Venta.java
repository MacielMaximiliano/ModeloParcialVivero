package ar.edu.unlam.pb1.vivero;

import java.util.Objects;

public class Venta {

	private Integer id;
	private Integer unidades;
	private Planta planta;
	public Double precioUnitario; // Precio final de la planta al momento de realizar la venta
	private static Integer idStatic = 0;

	public Venta(Integer unidades, Planta planta, Double precioUnitario) {
		super();
		this.id = idStatic++;
		this.unidades = unidades;
		this.planta = planta;
		this.precioUnitario = precioUnitario;
	}

	public Integer getId() {
		return id;
	}



	public Integer getUnidades() {
		return unidades;
	}

	public Planta getPlanta() {
		return planta;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, planta, precioUnitario, unidades);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(id, other.id) && Objects.equals(planta, other.planta)
				&& Objects.equals(precioUnitario, other.precioUnitario) && Objects.equals(unidades, other.unidades);
	}
		
}
