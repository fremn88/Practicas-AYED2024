package tp2.ej9;

public class Datos {
	private Integer suma;
	private Integer diferencia;
	
	public Datos() {
		
	}
	
	public Datos(Integer suma,Integer diferencia) {
		this.suma = suma;
		this.diferencia = diferencia;
	}
	
	public Integer getSuma() {
		return this.suma;
	}
	
	public Integer getDiferencia() {
		return this.diferencia;
	}
	
	public void setSuma(Integer suma) {
		this.suma = suma;
	}
	
	public void setDiferencia(Integer diferencia) {
		this.diferencia = diferencia;
	}
}

