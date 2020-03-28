package macowins.models.entity;

public class Liquidacion implements iEstado {

	public float restaPorEstado(float precioPrenda) {
		return precioPrenda*0.5f;
	}

}
