package triLazy;

public class DatosGene<T> {
	
	private T valor;
	
	public DatosGene(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	

}
