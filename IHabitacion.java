package triLazy;

public interface IHabitacion {

	public double anadir_valor();
	public double calcular_precio() ;

	public boolean distribucion_camas(int personas) ;
	public void muestra_habitacion(int dias) ;

	public boolean filtra_habitacion(int personas, int presupuesto, int dias);

}
