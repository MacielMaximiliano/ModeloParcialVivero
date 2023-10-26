package ar.edu.unlam.pb1.vivero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vivero {

	private String nombre;

	// No se pueden registrar plantas duplicadas. 2 plantas son iguales cuando tiene
	// el mismo Id
	private Set<Planta> plantas;
	private List<Venta> ventas;

	public String getNombre() {
		return nombre;
	}
	
	public Set<Planta> getPlantas() {
		return plantas;
	}

	public List<Venta> getVentas() {
		return ventas;
	}


	public Vivero(String nombre) {
		this.nombre = nombre;
		this.plantas = new HashSet<Planta>();
		this.ventas = new ArrayList<Venta>();
	}

	// No puede haber 2 plantas con el mismo Id , Si se duplica lanza una Exception
	// Planta Duplicada Exception
	public Boolean agregarPlanta(Planta planta) throws PlantaDuplicadaException {

		if (!plantas.contains(planta)) {
			return plantas.add(planta);
		}

		throw new PlantaDuplicadaException("la planta esta duplicada");

	}

	/*
	 * Registra una venta y descuenta del stock de la planta la cantidad deseada. Si
	 * no se encuentra la planta lanza una exception Planta Inexistente. Si no hay
	 * Stock Lanza Una Exception ProdutoSinStockException
	 */

	public Boolean venderPlanta(Integer codigoPlanta, Integer cantidadAVender)
			throws PlantaNoEncontradaException, ProdutoSinStockException {

		Planta planta = buscarPlanta(codigoPlanta);
		if (planta.getStock() > cantidadAVender) {
			planta.setStock(cantidadAVender);

			ventas.add(new Venta(cantidadAVender, planta, planta.obtenerPrecio()));

			return true;
		}

		throw new ProdutoSinStockException("No hay stock suficiente");
	}

	public Planta buscarPlanta(Integer codigoPlanta) throws PlantaNoEncontradaException {
		for (Planta planta : plantas) {
			if (planta.getCodigo() == codigoPlanta) {
				return planta;
			}
		}

		throw new PlantaNoEncontradaException("planta no encontrada");

	}

	/*
	 * Obtener un listado de todos los arboles vendidos ordenados por el total de
	 * venta (Cantidad * precioDeLaPlanta)
	 * 
	 */
	public TreeSet<Venta> obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() {

		TreeSet<Venta> ventasOrdenadas = new TreeSet<Venta>(new ventasOrdenadas());
		ventasOrdenadas.addAll(ventas);
		return ventasOrdenadas;

		//TODO falta metodo q filtre los instance of arboles
		
	}
	
	
	
	
	
	

	/**
	 * Obtener una lista de plantas que implementen la interfaz correspondiente
	 */
	public List<Florales> obtenerTodasLasPlantasFlorales() {
		List<Florales> aux = new ArrayList<Florales>();
		for (Planta planta : plantas) {
			if (planta instanceof Florales) {
				aux.add((Florales) planta);
			}
		}
		return aux;
	}

	/*
	 * Obtener Un reporte de las plantas vendidas agrupados por tipo Plantas
	 * 
	 * 
	 * Ejemplo: para una key "arbol", debemos completar las plantas de este tipo
	 * 
	 */
	public Map<String, Planta> obtenerReporteDePlantasAgrupadasPorTipo() {
		// TODO hacer un doble map yo que se
		return null;
	}
}
