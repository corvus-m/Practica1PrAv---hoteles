package triLazy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IHabitacionTest {		//mirar como implementarlo con abstract

	public IHabitacion I;
	   
	public IHabitacionTest(IHabitacion I) {
		this.I = I;
		this.I.
	}	//instancio I como abstracto? seria el antiguo createInstance();
	
	    @Test
	    public final void testDistribucion_True() {
	    	assert true(I.distribucion_camas(4));
	    }

	    @Test
	    public final void testMyMethod_False() {
	        MyInterface instance = createInstance();
	        assertFalse(instance.myMethod(false));
	    }
	   
	   
	   
	   
	   

}



//public double calcular_precio() ;
//
//public boolean distribucion_camas(int personas) ;
//	public void muestra_habitacion(int dias) ;
//
//	public boolean filtra_habitacion(int personas, int presupuesto, int dias);

