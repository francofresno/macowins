package macowins.models.entity;

public class Tarjeta implements iFormaPago {

	private int cuotas;
	private float coeficienteRecargo;

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public float getCoeficienteRecargo() {
		return coeficienteRecargo;
	}

	public void setCoeficienteRecargo(float coeficienteRecargo) {
		this.coeficienteRecargo = coeficienteRecargo;
	}

	public float recargo(float precioPrendas) {
		return cuotas * coeficienteRecargo + 0.01f * precioPrendas;
	}

}
