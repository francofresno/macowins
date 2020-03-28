package macowins.models.entity;

public class Prenda {
	
	private String tipo;
	private int precioBase;
	private iEstado estado;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	public iEstado getEstado() {
		return estado;
	}
	public void setEstado(iEstado estado) {
		this.estado = estado;
	}
	
	public float precio() {
		float precio = precioBase - estado.restaPorEstado(precioBase);
		return precio < 0 ? 0 : precio;
	}
	
}
