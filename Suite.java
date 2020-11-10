package triLazy;

public class Suite extends Habitacion{

	private boolean jacuzzi;
	private int vistasMonumento;	//valor segun importancia monumento o calidad de las vistas
	
	
	//constructores
	public Suite(String nombre, int camitas, int camotas, int estrellas, int vistas) {
		super(nombre, camitas, camotas, estrellas);
		this.jacuzzi = true;
		this.vistasMonumento = vistas;
	}
	
	
	public Suite(String nombre, int camitas, int camotas, int estrellas, int vistas, boolean jacuzzi) {
		super(nombre, camitas, camotas);
		this.jacuzzi = jacuzzi;
		this.vistasMonumento = vistas;
	}
	
	
	//getters setters
	public boolean getJacuzzi() {
		return jacuzzi;
	}
	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}
	public int getVistasMonumento() {
		return vistasMonumento;
	}
	public void setVistasMonumento(int vistasMonumento) {
		this.vistasMonumento = vistasMonumento;
	}
	
	
	
	
	public double calcular_precio() {
		
		double aux =super.calcular_precio() * 1.2;
		
		//System.out.println("\nprecio:"+ aux);
		if (this.getJacuzzi())
			aux++;
		
		//System.out.println("\nprecio:"+ aux);
		aux=aux + 0.3*this.getVistasMonumento();
			
		//System.out.println("\nprecio:"+ aux);
		return aux;
	}


	public void muestra_habitacion(int dias, int descuento) {
		
		super.muestra_habitacion(dias, descuento);
		
		if (this.getJacuzzi())
		System.out.println("\tEsta habitacion cuenta con jacuzzi.");
		
		if (this.getVistasMonumento() > 0)
			System.out.println("\tEsta habitacion cuenta con una calidad de vistas de: " + this.getVistasMonumento() + "/5");
		
	}

	

}
