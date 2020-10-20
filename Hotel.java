package triLazy;


import java.util.Vector;


/**
 * @author Nitropc
 *
 */
public class Hotel {				//es o no es como trivago
	private String nombre;
	private int estrellas;			//resulta que no existe unsigned
	private String direccion;
	private int num_habit;

	private Boolean piscina;
	private Boolean pista_tennis;
	private Boolean restaurante;
	private Boolean bar;

	private Vector<Habitacion> habitaciones;




	// Constructor/es
	public Hotel(String nombre, int estrellas, String direccion) {
		this.nombre=nombre;
		this.estrellas=estrellas;
		this.direccion=direccion;
		this.num_habit=0;
		this.piscina=false;
		this.pista_tennis=false;
		this.restaurante=false;
		this.bar=false;
		
		this.habitaciones = new Vector<Habitacion>();

	}






	//getters & setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public int getNum_habit() {
		return num_habit;
	}

	public void setNum_habit(int num_habit) {
		this.num_habit = num_habit;
	}

	public Boolean getPiscina() {
		return piscina;
	}

	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}

	public Boolean getPista_tennis() {
		return pista_tennis;
	}

	public void setPista_tennis(Boolean pista_tennis) {
		this.pista_tennis = pista_tennis;
	}

	public Boolean getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Boolean restaurante) {
		this.restaurante = restaurante;
	}

	public Boolean getBar() {
		return bar;
	}

	public void setBar(Boolean bar) {
		this.bar = bar;
	}

	public Vector<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Vector<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}







	//metodos



	private void caracteristicas_Hotel() {

		System.out.println("Estrellas: " + this.getEstrellas());
		System.out.println("Direccion: " + this.getDireccion());
		if(this.getPiscina() == true) System.out.println("Incluye piscina.");
		if(this.getPista_tennis() == true) System.out.println("Incluye pista de tennis.");
		if(this.getRestaurante() == true) System.out.println("Incluye restaurante.");
		if(this.getBar() == true) System.out.println("Incluye bar.");
	}

	public void muestra_Hotel(int dias) {
		System.out.println("\n\nEl Hotel " + this.getNombre()  + " dispone de estas caracteristicas: ");
		this.caracteristicas_Hotel();

		System.out.println("Ademas de estas habitaciones:");
		for(Habitacion elem: this.getHabitaciones())
			elem.muestra_habitacion(dias);
	}

	public void filtra_Hotel(int personas, int precio, int dias) {

		Vector<Habitacion> aux = new Vector<Habitacion>();
		int cont=0;
		for(Habitacion elem: this.getHabitaciones())
			if(elem.filtra_habitacion(personas, precio, dias)) {
				aux.add(elem);
				cont++;
			}
		if(cont!=0) {
			System.out.println("\n\n\nEl Hotel " + this.getNombre() + " dispone de estas caracteristicas: ");
			this.caracteristicas_Hotel();

			System.out.println("Ademas de estas habitaciones.");
			for(Habitacion elem: aux)
				elem.muestra_habitacion(dias);
		}

	}

	public void filtra_Hotel( int personas, int precio, int dias, int descuento) {
		Vector<Habitacion> aux = new Vector<Habitacion>();
		int cont=0;
		for(Habitacion elem: this.getHabitaciones())
			if(elem.filtra_habitacion(personas, precio, dias, descuento)) {
				aux.add(elem);
				cont++;
			}
		if(cont!=0) {
			System.out.println("El Hotel " + this.getNombre()  + " dispone de estas caracteristicas: ");
			this.caracteristicas_Hotel();

			System.out.println("Ademas de estas habitaciones.");
			for(Habitacion elem: aux)
				elem.muestra_habitacion(dias, descuento);
		}

	}










	public void anade_hab(String nombre, int camitas, int camotas) {

		Habitacion nueva = new Habitacion(nombre, camitas, camotas, this.getEstrellas());

		this.habitaciones.addElement(nueva);

		this.setNum_habit(this.getNum_habit()+1);
	}



	//vector de hoteles con sus vectores de habitaciones



	//public Vector<Habitacion> habitacion_por_precio(int valor, int zona);  //hacer por zonas?

	//public Vector<Hotel> Hotel_por_estrellas();
	//public Vector<Hotel> Hotel_por_estrellas();
	//public Vector<Hotel> Hotel_por_estrellas();

}
