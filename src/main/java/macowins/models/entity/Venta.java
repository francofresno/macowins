package macowins.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import macowins.models.repository.VentasRepository;

public class Venta {
	private List<Prenda> prendas;
	private Date fecha;
	private iFormaPago formaPago;
	private float costoTotal;
	
	private VentasRepository repository;

	public Venta() {
		this.prendas = new ArrayList<Prenda>();
		this.fecha = new Date();
		this.costoTotal = 0f;
		this.repository = new VentasRepository();
	}

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public iFormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(iFormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public float getCostoTotal() {
		return costoTotal;
	}

	public void addPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
	public void removePrenda(Prenda prenda) {
		prendas.remove(prenda);
	}

	public int getCantidad() {
		return prendas.size();
	}
	
	public void definirCostoTotal() {
		float precioPrendas = this.calcularPrecioPrendas();
		costoTotal = precioPrendas + formaPago.recargo(precioPrendas);
	}
	
	public void cerrarVenta() {
		this.definirCostoTotal();
		repository.save(this);
	}
	
	private float calcularPrecioPrendas() {
		return (float) prendas.stream().mapToDouble(prenda -> prenda.precio()).sum();
	}

}
