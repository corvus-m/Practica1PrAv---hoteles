package triLazy;

public class Habitacion implements IHabitacion {
	

	
	
	protected String nom_habi;
	protected int camas_ind;
	protected int camas_matrimonio;
	protected Boolean pisc_incluida;
	protected Boolean incluye_buffet;
	protected int estrellas_hotel;		
	
	
	
	


	//Constructor
	public Habitacion(String nombre, int camitas, int camotas) {
		this.nom_habi=nombre;
		this.camas_ind = camitas;
		this.camas_matrimonio = camotas;
		this.pisc_incluida = false;
		this.incluye_buffet = false;
		this.estrellas_hotel = 5;
	}
	
	
	public Habitacion(String nombre, int camitas, int camotas, int estrellas) {
		this.nom_habi=nombre;
		this.camas_ind = camitas;
		this.camas_matrimonio = camotas;
		this.pisc_incluida = false;
		this.incluye_buffet = false;
		this.estrellas_hotel = estrellas;
	}
	
	
	//metodos
	public double anadir_valor() {	//ya no es protected por la refactorizacion necesaria para una buena interfaz
		return (this.pisc_incluida || this.incluye_buffet)? ((this.pisc_incluida && this.incluye_buffet)? 3.0 : 1.5) : 0; 
	}
	
	
	
	public double calcular_precio() {
		
		double aux = (double)(this.getEstrellas_hotel()*4) + (this.getCamas_ind()*(2.0+0.5*this.getEstrellas_hotel())) + (this.getCamas_matrimonio()*(3.0+0.5*this.getEstrellas_hotel()) + this.anadir_valor());
		
		 return aux;
		
	}
	
	
	public boolean distribucion_camas(int personas) {
	
		return ((this.getCamas_ind() + this.getCamas_matrimonio()*2) >= personas)? true: false;

	}
	
	public boolean distribucion_camas(int personas, boolean familia) {	//para que incluya descuento de familia numerosa requiere de almenos 1 cama de matrimonio
		if (familia && (this.getCamas_matrimonio()>=1)) {
			
			if ( (this.getCamas_ind() + this.getCamas_matrimonio()*2) >= personas)
				return true;
		}
		else if (!familia && ((this.getCamas_ind() + this.getCamas_matrimonio()*2) >= personas))
			return true;
		
		return false;
	}
	
												//hacer privado y sacar sus public?
	public void muestra_habitacion(int dias) {
		
		System.out.println("\n"+ this.nom_habi);
		System.out.println("\tPrecio por noche: " + this.calcular_precio()  + " euros" );
		System.out.println("\tPrecio total: " + this.calcular_precio()  * dias + " euros" );
		if(this.camas_ind>0)
			System.out.println("\tCamas individuales:" + camas_ind);
		if(this.camas_ind>0)
			System.out.println("\tCamas individuales:" + camas_matrimonio);

		System.out.print("\tPiscina: ");
		if(this.pisc_incluida)
			System.out.println("Si");
		else System.out.println("No");

		System.out.print("\tBuffet: ");
		if(this.incluye_buffet)
			System.out.println("Si");
		else System.out.println("No");
	}
	
	
	public void muestra_habitacion(int dias, int descuento) {
		
		System.out.println("\n"+ this.nom_habi);
		System.out.println("\tPrecio: " + this.calcular_precio() + " euros" );
		
		if (descuento!=0){
		System.out.println("\tPrecio total sin descuento: " + (this.calcular_precio() * dias) + " euros" );
		System.out.println("\tPrecio con descuento: " + (this.calcular_precio()  * (1.0 - (float)descuento / 100) * dias) + " euros" );
		}
		
		if(this.camas_ind>0)
			System.out.println("\tCamas individuales:" + camas_ind);
		if(this.camas_ind>0)
			System.out.println("\tCamas individuales:" + camas_matrimonio);

		System.out.print("\tPiscina: ");
		if(this.pisc_incluida)
			System.out.println("Si");
		else System.out.println("No");

		System.out.print("\tBuffet: ");
		if(this.incluye_buffet)
			System.out.println("Si");
		else System.out.println("No");
	}
	
	
	public boolean filtra_habitacion(int personas, int presupuesto, int dias) {
			
		if (this.calcular_precio()*dias > presupuesto)
			return false;
		else if( this.distribucion_camas(personas) == false)
			return false;
		return true;	
	}
	
	
	
	public boolean filtra_habitacion(int personas, int presupuesto, int dias, int descuento) {
		boolean familia=false;
		if (descuento>10) {
			familia=true;
			--descuento;
		}
		
		if (this.calcular_precio()*dias*(1.0- (float)descuento/100) > presupuesto)	//otra forma de calcular el descuento es sacar el valor resultante del total por el porcentaje usado del precio
			return false;
		else if( this.distribucion_camas(personas, familia) ==false)
			return false;
		return true;	
	}
	
	
	
	
	public int getCamas_ind() {
		return camas_ind;
	}
	public void setCamas_ind(int camas_ind) {
		this.camas_ind = camas_ind;
	}
	public int getCamas_matrimonio() {
		return camas_matrimonio;
	}
	public void setCamas_matrimonio(int camas_matrimonio) {
		this.camas_matrimonio = camas_matrimonio;
	}
	public Boolean getPisc_incluida() {
		return pisc_incluida;
	}
	public void setPisc_incluida(Boolean pisc_incluida) {
		this.pisc_incluida = pisc_incluida;
	}
	public Boolean getIncluye_buffet() {
		return incluye_buffet;
	}
	public void setIncluye_buffet(Boolean incluye_buffet) {
		this.incluye_buffet = incluye_buffet;
	}
	public String getNom_habi() {
		return nom_habi;
	}

	public void setNom_habi(String nom_habi) {
		this.nom_habi = nom_habi;
	}

	public int getEstrellas_hotel() {
		return estrellas_hotel;
	}

	public void setEstrellas_hotel(int estrellas_hotel) {
		this.estrellas_hotel = estrellas_hotel;
	}

	
	

}
