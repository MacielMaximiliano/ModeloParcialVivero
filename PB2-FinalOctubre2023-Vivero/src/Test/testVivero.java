package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ar.edu.unlam.pb1.vivero.*;

public class testVivero {

	// - 1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
	@Test
	public void QueSePuedaAgregarPlanta() throws PlantaDuplicadaException {

		Vivero vivero = new Vivero("Vivero pichu");
		Planta planta = new Arbol(1, "arbolico", 5.0, 3);

		// vivero.agregarPlanta(planta);
		assertTrue(vivero.agregarPlanta(planta));

	}

	@Test(expected = PlantaDuplicadaException.class)
	public void QueSNoePuedaAgregarPlanta() throws PlantaDuplicadaException {

		Vivero vivero = new Vivero("Vivero pichu");
		Planta planta = new Arbol(1, "arbolico", 5.0, 3);
		Planta planta2 = new Arbol(1, "arbolico2", 5.0, 3);

		// vivero.agregarPlanta(planta);
		assertTrue(vivero.agregarPlanta(planta));
		vivero.agregarPlanta(planta2);
	}

	@Test
	// - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion
	public void QueSePuedaVenderPlantaa()
			throws PlantaNoEncontradaException, PlantaDuplicadaException, ProdutoSinStockException {

		Vivero vivero = new Vivero("Vivero pichu");

		Planta planta = new Arbol(1, "arbolico", 5.0, 5);
		vivero.agregarPlanta(planta);
		vivero.venderPlanta(planta.getCodigo(), 1);

		assertEquals(4, vivero.buscarPlanta(planta.getCodigo()).getStock());

	}

	@Test(expected = ProdutoSinStockException.class)
	public void QueSeNoPuedaVenderPlantaXStock()
			throws PlantaNoEncontradaException, PlantaDuplicadaException, ProdutoSinStockException {

		Vivero vivero = new Vivero("Vivero pichu");

		Planta planta = new Arbol(1, "arbolico", 5.0, 5);
		vivero.agregarPlanta(planta);
		vivero.venderPlanta(planta.getCodigo(), 10);

		assertEquals(4, vivero.buscarPlanta(planta.getCodigo()).getStock());

	}

	@Test(expected = PlantaNoEncontradaException.class)
	public void QueSeNoPuedaVenderPlantaXplantaNoEncontrada()
			throws PlantaNoEncontradaException, PlantaDuplicadaException, ProdutoSinStockException {

		Vivero vivero = new Vivero("Vivero pichu");

		Planta planta = new Arbol(1, "arbolico", 5.0, 5);
		vivero.agregarPlanta(planta);
		vivero.venderPlanta(123, 1);

		assertEquals(4, vivero.buscarPlanta(planta.getCodigo()).getStock());

	}

	// - 1 test para el metodo
	// obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
	@Test
	public void obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
			throws PlantaNoEncontradaException, PlantaDuplicadaException, ProdutoSinStockException {

		Vivero vivero = new Vivero("Vivero pichu");

		Planta planta = new Arbol(1, "arbolico", 5.0, 5);
		Planta planta2 = new Arbol(2, "arbolito2", 10.0, 3);
		Planta planta3 = new Arbol(3, "arbolito3", 2.0, 4);

		vivero.agregarPlanta(planta);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);

		vivero.venderPlanta(planta.getCodigo(), 1);
		vivero.venderPlanta(planta2.getCodigo(), 1);
		vivero.venderPlanta(planta3.getCodigo(), 1);

		vivero.obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta();


		// Verifica que las ventas estén ordenadas por valor total de venta en orden
		// ascendente.
		List<Venta> ventas = new ArrayList<>(vivero.obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta());
		for (int i = 1; i < ventas.size(); i++) {
			Double valorVentaActual = ventas.get(i).getPrecioUnitario() * ventas.get(i).getUnidades();
			Double valorVentaAnterior = ventas.get(i - 1).getPrecioUnitario() * ventas.get(i - 1).getUnidades();
			assertTrue(valorVentaActual >= valorVentaAnterior);

		}

	}

	@Test
	// TODO
	// 1 test para el metodo obtenerReporteDePlantasAgrupadasPorTipo()
	public void obtenerReporteDePlantasAgrupadasPorTipo() {
	}

	@Test
	// TODO
	// 1 test para el metodo obtenerTodasLasPlantasFlorales()
	public void obtenerTodasLasPlantasFlorales() {
	}

	@Test
	// - 1 test para el metodo obtenerPrecio() de la clase Planta
	public void obtenerPrecio() throws PlantaNoEncontradaException, PlantaDuplicadaException, ProdutoSinStockException {

		Vivero vivero = new Vivero("Vivero pichu");

		Planta planta = new Arbol(1, "arbolico", 5.0, 5);
		Planta planta2 = new Arbol(2, "arbolito2", 10.0, 3);
		Planta planta3 = new Arbol(3, "arbolito3", 2.0, 4);

		vivero.agregarPlanta(planta);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);

		vivero.venderPlanta(planta.getCodigo(), 1);
		vivero.venderPlanta(planta2.getCodigo(), 1);
		vivero.venderPlanta(planta3.getCodigo(), 1);

		Double ve = planta.getPrecioBase() * ((Arbol) planta).getGANANCIA_ARBOL();

		assertEquals(vivero.buscarPlanta(planta.getCodigo()).obtenerPrecio(), ve, 0.01);

	}

	@Test
	// TODO
	// - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la
	// interfaz Florales en estado de floracion
	public void obtenerPrecioFloracion() {
	}

	@Test
	// TODO
	// - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la
	// interfaz Florales en estado de produccion
	public void obtenerPrecioProduccion() {
	}

}
