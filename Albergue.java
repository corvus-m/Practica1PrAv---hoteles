package triLazy;

import java.util.Vector;

public class Albergue extends Hotel {
	
	private String zona;
	private boolean travesia;	//si este alberge pertenece a una ruta o travesia transitada por muchos turistas
	
	
	//constructores
	public Albergue(String nombre, int estrellas, String direccion, String zona) {
		super(nombre, estrellas, direccion);

		this.zona = (zona);
		this.travesia = false;
	}
	
	public Albergue(String nombre, int estrellas, String direccion, String zona, boolean travesia) {
		super(nombre, estrellas, direccion);
		
		this.zona = (zona);
		this.travesia = travesia;	
	}
	
	
	
	//getters y setters
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public boolean getTravesia() {
		return travesia;
	}
	public void setTravesia(boolean travesia) {
		this.travesia = travesia;
	}
	
	
	//funciones
	
	public void caracteristicas_Hotel() {
		
		super.caracteristicas_Hotel();
		System.out.println("Zona: " + this.getZona());
	}
	
	public int filtra_Hotel(int personas, int precio, int dias) {

		Vector<Habitacion> aux = new Vector<Habitacion>();
		int cont=0;
		for(Habitacion elem: this.getHabitaciones()) {
			if(elem instanceof Suite) continue; //esto sirve para no contar una habitacion suite para un albergue porque queremos considerar ese caso un error de introduccion de datos
			else if(elem.filtra_habitacion(personas, precio, dias)) {
				aux.add(elem);
				cont++;
			}
		}
		if(cont!=0) {
			System.out.println("\n\n\nEl Hotel " + this.getNombre() + " dispone de estas caracteristicas: ");
			this.caracteristicas_Hotel();

			System.out.println("Ademas de estas habitaciones.");
			for(Habitacion elem: aux)
				elem.muestra_habitacion(dias);
		}
		return cont;
	}
	
	public int filtra_Hotel(int personas, int precio, int dias, int descuento) {

		Vector<Habitacion> aux = new Vector<Habitacion>();
		int cont=0;
		for(Habitacion elem: this.getHabitaciones()) {
			if(elem instanceof Suite) continue; //esto sirve para no contar una habitacion suite para un albergue porque queremos considerar ese caso un error de introduccion de datos
			if(elem.filtra_habitacion(personas, precio, dias, descuento)) {
				aux.add(elem);
				cont++;
			}
		}
		if(cont!=0) {
			System.out.println("\n\n\nEl Hotel " + this.getNombre() + " dispone de estas caracteristicas: ");
			this.caracteristicas_Hotel();

			System.out.println("Ademas de estas habitaciones.");
			for(Habitacion elem: aux)
				elem.muestra_habitacion(dias, descuento);
		}
		return cont;
	}
	
	
	public void anade_hab(String nombre, int camitas, int camotas) {

		Habitacion nueva = new Habitacion(nombre, camitas, camotas, this.getEstrellas());

		this.habitaciones.addElement(nueva);

		this.setNum_habit(this.getNum_habit()+1);
	}

	
	
	
}
