package macowins.models.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import macowins.models.entity.Venta;

public class VentasRepository {
	private List<Venta> ventas;

	public VentasRepository() {
		this.ventas = new ArrayList<Venta>();
	}
	
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public void save(Venta venta) {
		ventas.add(venta);
	}
	
	public void delete(Venta venta) {
		ventas.remove(venta);
	}
	
	public float obtenerGananciasDeFecha(Date fecha) {
		return (float) this.filterVentasByDate(fecha).stream().mapToDouble(venta -> venta.getCostoTotal()).sum();
	}
	
	private List<Venta> filterVentasByDate(Date fecha) {
		return ventas.stream().filter( venta -> venta.getFecha() == fecha).collect(Collectors.toList());
	}

}
