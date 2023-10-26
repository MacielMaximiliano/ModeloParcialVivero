package ar.edu.unlam.pb1.vivero;

import java.util.Comparator;

public class ventasOrdenadas implements Comparator<Venta> {

	@Override
	public int compare(Venta venta1, Venta venta2) {
		double valorVenta1 = venta1.getUnidades() * venta1.getPrecioUnitario();
		double valorVenta2 = venta2.getUnidades() * venta2.getPrecioUnitario();

		if (valorVenta1 < valorVenta2) {
			return -1;
		} else if (valorVenta1 > valorVenta2) {
			return 1;
		} else {
			return 0;
		}
	}
};
